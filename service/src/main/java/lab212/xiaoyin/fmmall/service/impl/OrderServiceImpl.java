package lab212.xiaoyin.fmmall.service.impl;


import lab212.xiaoyin.fmmall.dao.OrderItemMapper;
import lab212.xiaoyin.fmmall.dao.OrdersMapper;
import lab212.xiaoyin.fmmall.dao.ProductSkuMapper;
import lab212.xiaoyin.fmmall.dao.ShoppingCartMapper;
import lab212.xiaoyin.fmmall.entity.*;
import lab212.xiaoyin.fmmall.service.OrderService;
import lab212.xiaoyin.fmmall.utils.PageHelper;
import lab212.xiaoyin.fmmall.vo.ResStatus;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    /**
     * 保存订单业务
     */
    @Override
    @Transactional
    public Map<String, String> addOrder(String cids, Orders order) throws SQLException {
        logger.info("add order begin...");
        Map<String, String> map = null;

        //1.校验库存：根据cids查询当前订单中关联的购物车记录详情（包括库存）
        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByCids(cidsList);
        //分布式锁
        boolean locked = true;
        String[] skuIds = new String[list.size()];
        Map<String, RLock> locks = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String skuId = list.get(i).getSkuId();
            boolean b = false;
            try {
                RLock lock = redissonClient.getLock(skuId);
                b = lock.tryLock(10, 3, TimeUnit.SECONDS);
                if (b) {
                    skuIds[i] = skuId;
                    locks.put(skuId, lock);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            locked = locked & b;
        }

        //加“锁”成功
        try {
            if (locked) {
                list = shoppingCartMapper.selectShopcartByCids(cidsList);
                boolean f = true;
                String untitled = "";
                for (ShoppingCartVO sc : list) {
                    if (Integer.parseInt(sc.getCartNum()) > sc.getSkuStock()) {
                        f = false;
                    }
                    //获取所有商品名称，以,分割拼接成字符串
                    untitled = untitled + sc.getProductName() + ",";
                }

                if (f) {
                    logger.info("product stock is OK...");
                    map = new HashMap<>();
                    //2.保存订单
                    order.setUntitled(untitled);
                    order.setCreateTime(new Date());
                    order.setStatus("1");
                    //生成订单编号
                    String orderId = UUID.randomUUID().toString().replace("-", "");
                    order.setOrderId(orderId);
                    int i = ordersMapper.insert(order);

                    //3.生成商品快照
                    for (ShoppingCartVO sc : list) {
                        int cnum = Integer.parseInt(sc.getCartNum());
                        String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(89999) + 10000);
                        OrderItem orderItem = new OrderItem(itemId, orderId, sc.getProductId(), sc.getProductName(), sc.getProductImg(), sc.getSkuId(), sc.getSkuName(), new BigDecimal(sc.getSellPrice()), cnum, new BigDecimal(sc.getSellPrice() * cnum), new Date(), new Date(), 0);
                        orderItemMapper.insert(orderItem);
                        //增加商品销量
                    }

                    //4.扣减库存：根据套餐ID修改套餐库存量
                    for (ShoppingCartVO sc : list) {
                        String skuId = sc.getSkuId();
                        int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                        ProductSku productSku = new ProductSku();
                        productSku.setSkuId(skuId);
                        productSku.setStock(newStock);
                        productSkuMapper.updateByPrimaryKeySelective(productSku);
                    }

                    //5.删除购物车：当购物车中的记录购买成功之后，购物车中对应做删除操作
                    for (int cid : cidsList) {
                        shoppingCartMapper.deleteByPrimaryKey(cid);
                    }
                    //释放锁
                    for (int m = 0; m < skuIds.length; m++) {
                        String skuId = skuIds[m];
                        if (skuId != null && !"".equals(skuId)) {
                            locks.get(skuId).unlock();
                        }
                    }

                    logger.info("add order finished...");
                    map.put("orderId", orderId);
                    map.put("productNames", untitled);
                }
                return map;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            for (int i = 0; i < skuIds.length; i++) {
                String skuId = skuIds[i];
                if (skuId != null && !"".equals(skuId)) {
                    locks.get(skuId).unlock();
                }
            }
        }
        return null;
    }

    @Override
    public int updateOrderStatus(String orderId, String status) {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setStatus(status);
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        return i;
    }

    @Override
    public ResultVO getOrderById(String orderId) {
        Orders order = ordersMapper.selectByPrimaryKey(orderId);
        return new ResultVO(ResStatus.OK, "sucesss", order.getStatus());
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void closeOrder(String orderId) {
        synchronized (this) {
            //  1.修改当前订单：status=6 已关闭  close_type=1 超时未支付
            Orders cancleOrder = new Orders();
            cancleOrder.setOrderId(orderId);
            cancleOrder.setStatus("6");  //已关闭
            cancleOrder.setCloseType(1); //关闭类型：超时未支付
            ordersMapper.updateByPrimaryKeySelective(cancleOrder);

            //  2.还原库存：先根据当前订单编号查询商品快照（skuid  buy_count）--->修改product_sku
            Example example1 = new Example(OrderItem.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("orderId", orderId);
            List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
            //还原库存
            for (int j = 0; j < orderItems.size(); j++) {
                OrderItem orderItem = orderItems.get(j);
                //修改
                ProductSku productSku = productSkuMapper.selectByPrimaryKey(orderItem.getSkuId());
                productSku.setStock(productSku.getStock() + orderItem.getBuyCounts());
                productSkuMapper.updateByPrimaryKey(productSku);
            }
        }
    }

    @Override
    public ResultVO listOrders(String userId, String status, int pageNum, int limit) {
        //1.分页查询
        int start = (pageNum - 1) * limit;
        List<OrdersVO> ordersVOS = ordersMapper.selectOrders(userId, status, start, limit);

        //2.查询总记录数
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("userId", userId);
        if (status != null && !"".equals(status)) {
            criteria.andLike("status", status);
        }
        int count = ordersMapper.selectCountByExample(example);

        //3.计算总页数
        int pageCount = count % limit == 0 ? count / limit : count / limit + 1;

        //4.封装数据
        PageHelper<OrdersVO> pageHelper = new PageHelper<>(count, pageCount, ordersVOS);
        ;
        return new ResultVO(ResStatus.OK, "SUCCESS", pageHelper);
    }


}

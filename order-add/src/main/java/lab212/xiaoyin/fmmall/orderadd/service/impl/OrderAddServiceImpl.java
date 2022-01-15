package lab212.xiaoyin.fmmall.orderadd.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.orderadd.dao.OrdersMapper;
import lab212.xiaoyin.fmmall.orderadd.feign.StockQueryClient;
import lab212.xiaoyin.fmmall.orderadd.service.OrderAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:26
 */
@Service
public class OrderAddServiceImpl implements OrderAddService {

    @Autowired
    private StockQueryClient stockQueryClient;

    @Autowired
    private OrdersMapper ordersMapper;

    @LcnTransaction
    @Transactional
    @Override
    public List<ShoppingCartVO> save(Orders order, String cids) {
        //1.校验库存

        //a.调用库存查询：stock-query服务
        List<ShoppingCartVO> list = stockQueryClient.query(cids);
        if (list != null || list.size() > 0) {
            boolean f = true;
            String untitled = "";
            for (ShoppingCartVO sc : list) {
                if (Integer.parseInt(sc.getCartNum()) > sc.getSkuStock()) {
                    f = false;
                    break;
                }
                //获取所有商品名称，以,分割拼接成字符串
                untitled = untitled + sc.getProductName() + ",";
            }
            if (f) {
                //库存充足
                //2.保存订单
                order.setUntitled(untitled);
                order.setCreateTime(new Date());
                order.setStatus("1");
                //生成订单编号
                int i = ordersMapper.insert(order);
                if (i > 0) {
                    return list;
                }
            }
        }
        return null;
    }
}

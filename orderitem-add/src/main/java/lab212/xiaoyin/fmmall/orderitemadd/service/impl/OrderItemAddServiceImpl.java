package lab212.xiaoyin.fmmall.orderitemadd.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import lab212.xiaoyin.fmmall.entity.OrderItem;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.orderitemadd.dao.OrderItemMapper;
import lab212.xiaoyin.fmmall.orderitemadd.service.OrderItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:12
 */
@Service
public class OrderItemAddServiceImpl implements OrderItemAddService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Transactional
    @LcnTransaction
    @Override
    public int save(List<ShoppingCartVO> list, String orderId) {
        int j = 0;
        for (ShoppingCartVO sc : list) {
            int cnum = Integer.parseInt(sc.getCartNum());
            String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(89999) + 10000);
            OrderItem orderItem = new OrderItem(itemId, orderId, sc.getProductId(), sc.getProductName(), sc.getProductImg(), sc.getSkuId(), sc.getSkuName(), new BigDecimal(sc.getSellPrice()), cnum, new BigDecimal(sc.getSellPrice() * cnum), new Date(), new Date(), 0);
            int i = orderItemMapper.insert(orderItem);
            j *= i;
            //增加商品销量
        }
        return j;
    }
}

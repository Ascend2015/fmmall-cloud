package lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.fmmall.beans.ShoppingCartVO;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.OrderAddClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 18:34
 */
@Component
public class OrderAddClientFallback implements OrderAddClient {
    @Override
    public List<ShoppingCartVO> saveOrder(Orders order, String cids) {
        System.out.println("order-add.....fallback");
        return null;
    }
}

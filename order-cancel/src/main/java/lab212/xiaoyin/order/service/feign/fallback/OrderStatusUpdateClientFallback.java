package lab212.xiaoyin.order.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.order.service.feign.OrderStatusUpdateClient;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:51
 */
@Component
public class OrderStatusUpdateClientFallback implements OrderStatusUpdateClient {
    @Override
    public int update(Orders order) {
        System.out.println("update order status failed in order-close");
        return 0;
    }
}

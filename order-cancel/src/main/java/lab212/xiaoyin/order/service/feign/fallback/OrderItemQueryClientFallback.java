package lab212.xiaoyin.order.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.OrderItem;
import lab212.xiaoyin.order.service.feign.OrderItemQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:55
 */
@Component
public class OrderItemQueryClientFallback implements OrderItemQueryClient {
    @Override
    public List<OrderItem> query(String orderId) {
        System.out.println("query item query failed in order-close");
        return null;
    }
}

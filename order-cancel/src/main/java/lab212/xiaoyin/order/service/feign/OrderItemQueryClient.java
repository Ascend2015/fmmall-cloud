package lab212.xiaoyin.order.service.feign;

import lab212.xiaoyin.fmmall.beans.OrderItem;
import lab212.xiaoyin.order.service.feign.fallback.OrderItemQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:53
 */
@FeignClient(value = "order-item-query", fallback = OrderItemQueryClientFallback.class)
public interface OrderItemQueryClient {

    @GetMapping("/orderItem/query")
    public List<OrderItem> query(@RequestParam("orderId") String orderId);
}

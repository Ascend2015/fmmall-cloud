package lab212.xiaoyin.order.service.feign;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.order.service.feign.fallback.OrderStatusUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:49
 */
@FeignClient(value = "order-status-update",fallback = OrderStatusUpdateClientFallback.class)
public interface OrderStatusUpdateClient {

    @PutMapping("/order/status/update")
    public int update(Orders order);
}

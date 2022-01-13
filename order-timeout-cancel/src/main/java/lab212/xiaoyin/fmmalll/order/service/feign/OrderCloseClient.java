package lab212.xiaoyin.fmmalll.order.service.feign;

import lab212.xiaoyin.fmmalll.order.service.feign.fallback.OrderCloseClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 01:10
 */
@FeignClient(value = "order-cancel", fallback = OrderCloseClientFallback.class)
public interface OrderCloseClient {
    @GetMapping("/order/close")
    public int close(@RequestParam("orderId") String orderId, @RequestParam("closeType") int closeType);
}

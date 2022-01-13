package lab212.xiaoyin.fmmalll.order.service.feign;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.fmmalll.order.service.feign.fallback.OrderTimeoutQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 00:54
 */
@FeignClient(value = "order-timeout-query", fallback = OrderTimeoutQueryClientFallback.class)
public interface OrderTimeoutQueryClient {

    @GetMapping("/order/query/timeout")
    public List<Orders> query();
}

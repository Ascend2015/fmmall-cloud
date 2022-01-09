package lab212.xiaoyin.fmmall.ordersubmit.service.feign;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.fmmall.beans.ShoppingCartVO;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback.OrderAddClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 18:32
 */
@FeignClient(value = "order-add", fallback = OrderAddClientFallback.class)
public interface OrderAddClient {

    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(@RequestBody Orders order, @RequestParam("cids") String cids);
}

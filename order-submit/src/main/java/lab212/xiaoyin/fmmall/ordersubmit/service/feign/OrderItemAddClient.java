package lab212.xiaoyin.fmmall.ordersubmit.service.feign;

import lab212.xiaoyin.fmmall.beans.ShoppingCartVO;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback.OrderItemAddClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 23:37
 */
@FeignClient(value = "orderitem-add", fallback = OrderItemAddClientFallback.class)
public interface OrderItemAddClient {

    @PostMapping("/item/save")
    public int addOrderItem(@RequestBody List<ShoppingCartVO> list, @RequestParam("orderId") String orderId);
}

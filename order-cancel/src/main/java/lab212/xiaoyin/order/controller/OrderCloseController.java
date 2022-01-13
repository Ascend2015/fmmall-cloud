package lab212.xiaoyin.order.controller;

import lab212.xiaoyin.order.service.OrderCloseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:19
 */
@RestController
public class OrderCloseController {

    @Autowired
    private OrderCloseService orderCloseService;

    @GetMapping("/order/close")
    public int close(String orderId, int closeType) {
        return orderCloseService.closeOrder(orderId,closeType);
    }
}

package lab212.xiaoyin.fmmall.order.controller;

import lab212.xiaoyin.fmmall.entity.OrderItem;
import lab212.xiaoyin.fmmall.order.service.OrderItemQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:31
 */
@RestController
public class OrderItemController {

    @Autowired
    private OrderItemQueryService orderItemQueryService;

    @GetMapping("/orderItem/query")
    public List<OrderItem> query(String orderId) {
        return orderItemQueryService.queryOrderItem(orderId);
    }
}

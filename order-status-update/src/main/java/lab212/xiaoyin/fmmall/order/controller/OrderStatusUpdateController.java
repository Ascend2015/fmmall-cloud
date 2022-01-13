package lab212.xiaoyin.fmmall.order.controller;

import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.order.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 17:45
 */
@RestController
public class OrderStatusUpdateController {

    @Autowired
    private OrderStatusUpdateService orderStatusUpdateService;

    @PutMapping("/order/status/update")
    public int update(@RequestBody Orders order) {
        return orderStatusUpdateService.updateStatus(order);
    }
}

package lab212.xiaoyin.fmmall.timeoutquery.controller;

import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.timeoutquery.service.OrderTimeoutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 17:30
 */
@RestController
public class OrderTimeoutQueryController {

    @Autowired
    private OrderTimeoutQueryService orderTimeoutQueryService;

    @GetMapping("/order/query/timeout")
    public List<Orders> query() {
        return orderTimeoutQueryService.listOrders();
    }
}

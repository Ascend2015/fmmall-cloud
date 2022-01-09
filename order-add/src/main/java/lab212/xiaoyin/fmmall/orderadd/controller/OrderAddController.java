package lab212.xiaoyin.fmmall.orderadd.controller;

import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.orderadd.service.OrderAddService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:23
 */
@RestController
public class OrderAddController {

    @Autowired
    private OrderAddService orderAddService;

    Logger logger = LoggerFactory.getLogger(OrderAddController.class);

    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(@RequestBody Orders order, String cids) {
        return orderAddService.save(order, cids);
    }
}

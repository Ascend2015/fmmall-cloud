package lab212.xiaoyin.fmmall.orderitemadd.controller;

import lab212.xiaoyin.fmmall.entity.OrderItem;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.orderitemadd.service.OrderItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:06
 */
@RestController
public class OrderItemAddController {

    @Autowired
    private OrderItemAddService orderItemAddService;

    @PostMapping("/item/save")
    public int addOrderItem(@RequestBody List<ShoppingCartVO> list, String orderId) {
        return orderItemAddService.save(list, orderId);
    }
}

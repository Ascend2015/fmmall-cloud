package lab212.xiaoyin.fmmall.orderitemadd.service;

import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:11
 */
public interface OrderItemAddService {

    public int save(List<ShoppingCartVO> list, String orderId);
}

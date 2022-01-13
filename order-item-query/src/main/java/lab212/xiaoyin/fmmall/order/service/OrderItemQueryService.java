package lab212.xiaoyin.fmmall.order.service;

import lab212.xiaoyin.fmmall.entity.OrderItem;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:33
 */
public interface OrderItemQueryService {

    public List<OrderItem> queryOrderItem(String orderId);
}

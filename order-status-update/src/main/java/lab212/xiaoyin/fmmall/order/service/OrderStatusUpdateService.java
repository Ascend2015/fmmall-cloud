package lab212.xiaoyin.fmmall.order.service;

import lab212.xiaoyin.fmmall.entity.Orders;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 17:57
 */
public interface OrderStatusUpdateService {

    public int updateStatus(Orders order);
}

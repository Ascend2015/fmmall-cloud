package lab212.xiaoyin.fmmall.order.service.impl;

import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.order.dao.OrdersMapper;
import lab212.xiaoyin.fmmall.order.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 17:57
 */
@Service
public class OrderStatusUpdateServiceImpl implements OrderStatusUpdateService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int updateStatus(Orders order) {
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i;
    }
}

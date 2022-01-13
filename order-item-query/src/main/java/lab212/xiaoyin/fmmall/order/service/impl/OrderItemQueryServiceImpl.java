package lab212.xiaoyin.fmmall.order.service.impl;

import lab212.xiaoyin.fmmall.entity.OrderItem;
import lab212.xiaoyin.fmmall.order.dao.OrderItemMapper;
import lab212.xiaoyin.fmmall.order.service.OrderItemQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:34
 */
@Service
public class OrderItemQueryServiceImpl implements OrderItemQueryService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> queryOrderItem(String orderId) {

        Example example1 = new Example(OrderItem.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("orderId", orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
        return orderItems;
    }
}

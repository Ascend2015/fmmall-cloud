package lab212.xiaoyin.fmmall.timeoutquery.service.impl;

import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.timeoutquery.dao.OrdersMapper;
import lab212.xiaoyin.fmmall.timeoutquery.service.OrderTimeoutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 17:32
 */
@Service
public class OrderTimeoutQueryServiceImpl implements OrderTimeoutQueryService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> listOrders() {
        //1.查询超过30min订单状态依然为待支付状态的订单
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "1");
        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
        criteria.andLessThan("createTime", time);
        List<Orders> orders = ordersMapper.selectByExample(example);
        return orders;
    }
}

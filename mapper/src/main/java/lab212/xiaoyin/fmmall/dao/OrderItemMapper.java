package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.OrderItem;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface OrderItemMapper extends GeneralDAO<OrderItem> {

    /**
     * 查订单
     *
     * @param orderId
     * @return
     */
    public List<OrderItem> listOrderItemsByOrderId(String orderId);
}
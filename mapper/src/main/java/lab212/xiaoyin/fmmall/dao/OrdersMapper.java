package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.entity.OrdersVO;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface OrdersMapper extends GeneralDAO<Orders> {

    /**
     * 查询订单
     *
     * @param userId
     * @param status
     * @param start
     * @param limit
     * @return
     */
    public List<OrdersVO> selectOrders(@Param("userId") String userId,
                                       @Param("status") String status,
                                       @Param("start") int start,
                                       @Param("limit") int limit);

}

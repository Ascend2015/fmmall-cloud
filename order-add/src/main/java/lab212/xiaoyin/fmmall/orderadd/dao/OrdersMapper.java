package lab212.xiaoyin.fmmall.orderadd.dao;

import lab212.xiaoyin.fmmall.entity.Orders;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 18:08
 */
@Repository
public interface OrdersMapper extends Mapper<Orders>, MySqlMapper<Orders> {
}

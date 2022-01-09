package lab212.xiaoyin.fmmall.orderitemadd.dao;

import lab212.xiaoyin.fmmall.entity.OrderItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:13
 */
@Repository
public interface OrderItemMapper extends Mapper<OrderItem>, MySqlMapper<OrderItem> {

}

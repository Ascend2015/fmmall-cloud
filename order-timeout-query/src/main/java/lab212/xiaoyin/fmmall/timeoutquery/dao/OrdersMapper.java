package lab212.xiaoyin.fmmall.timeoutquery.dao;

import lab212.xiaoyin.fmmall.entity.Orders;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 17:33
 */
@Repository
public interface OrdersMapper extends Mapper<Orders>, MySqlMapper<Orders> {
}

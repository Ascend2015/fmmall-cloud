package lab212.xiaoyin.fmmall.shopcartdel.dao;

import lab212.xiaoyin.fmmall.entity.ShoppingCart;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:12
 */
@Repository
public interface ShoppingCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
}

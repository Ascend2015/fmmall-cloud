package lab212.xiaoyin.fmmall.stockquery.dao;

import lab212.xiaoyin.fmmall.entity.ShoppingCart;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 01:14
 */
@Repository
public interface ShopCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
    public List<ShoppingCartVO> selectShopcartByCids(List<Integer> cids);
}

package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.ShoppingCart;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {

    /**
     * 通过用户名查购物车
     *
     * @param userId
     * @return
     */
    public List<ShoppingCartVO> selectShopcartByUserId(int userId);

    /**
     * 通过购物车id查询
     *
     * @param cartId
     * @param cartNum
     * @return
     */
    public int updateCartnumByCartid(@Param("cartId") int cartId,
                                     @Param("cartNum") int cartNum);

    /**
     * 查找购物车
     *
     * @param cids
     * @return
     */
    public List<ShoppingCartVO> selectShopcartByCids(List<Integer> cids);

}

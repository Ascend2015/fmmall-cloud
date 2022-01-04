package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.ProductSku;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface ProductSkuMapper extends GeneralDAO<ProductSku> {

    /**
     * 根据商品ID，查询当前商品所有套餐中价格最低的套餐
     * @param productId
     * @return
     */
    public List<ProductSku> selectLowerestPriceByProductId(String productId);

}

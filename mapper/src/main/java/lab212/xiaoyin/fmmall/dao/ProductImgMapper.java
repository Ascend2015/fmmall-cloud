package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.ProductImg;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    /**
     * 查商品图片
     *
     * @param productId
     * @return
     */
    public List<ProductImg> selectProductImgByProductId(int productId);

}
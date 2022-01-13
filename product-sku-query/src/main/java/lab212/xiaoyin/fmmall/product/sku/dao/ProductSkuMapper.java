package lab212.xiaoyin.fmmall.product.sku.dao;

import lab212.xiaoyin.fmmall.entity.ProductSku;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 23:05
 */
@Repository
public interface ProductSkuMapper extends Mapper<ProductSku>, MySqlMapper<ProductSku> {
}

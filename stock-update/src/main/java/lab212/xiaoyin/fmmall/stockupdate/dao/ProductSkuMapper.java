package lab212.xiaoyin.fmmall.stockupdate.dao;

import lab212.xiaoyin.fmmall.entity.ProductSku;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:58
 */
@Repository
public interface ProductSkuMapper extends Mapper<ProductSku>, MySqlMapper<ProductSku> {
}

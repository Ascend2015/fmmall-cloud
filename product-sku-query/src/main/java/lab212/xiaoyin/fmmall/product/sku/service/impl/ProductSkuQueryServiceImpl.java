package lab212.xiaoyin.fmmall.product.sku.service.impl;

import lab212.xiaoyin.fmmall.entity.ProductSku;
import lab212.xiaoyin.fmmall.product.sku.dao.ProductSkuMapper;
import lab212.xiaoyin.fmmall.product.sku.service.ProductSkuQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 23:07
 */
@Service
public class ProductSkuQueryServiceImpl implements ProductSkuQueryService {

    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Override
    public ProductSku queryProductSku(String skuId) {
        return productSkuMapper.selectByPrimaryKey(skuId);
    }
}

package lab212.xiaoyin.fmmall.product.sku.controller;

import lab212.xiaoyin.fmmall.entity.ProductSku;
import lab212.xiaoyin.fmmall.product.sku.service.ProductSkuQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 23:09
 */
@RestController
public class ProductSkuQueryController {

    @Autowired
    private ProductSkuQueryService productSkuQueryService;

    @GetMapping("/product/sku/query")
    public ProductSku query(String skuId) {
        return productSkuQueryService.queryProductSku(skuId);
    }
}

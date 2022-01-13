package lab212.xiaoyin.order.service.feign;

import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.order.service.feign.fallback.ProductSkuQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 00:24
 */
@FeignClient(value = "product-sku-query", fallback = ProductSkuQueryClientFallback.class)
public interface ProductSkuQueryClient {

    @GetMapping("/product/sku/query")
    public ProductSku query(@RequestParam("skuId") String skuId);
}

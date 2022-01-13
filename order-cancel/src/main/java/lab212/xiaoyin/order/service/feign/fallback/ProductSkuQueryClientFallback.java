package lab212.xiaoyin.order.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.order.service.feign.ProductSkuQueryClient;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 00:38
 */
@Component
public class ProductSkuQueryClientFallback implements ProductSkuQueryClient {
    @Override
    public ProductSku query(String skuId) {
        return null;
    }
}

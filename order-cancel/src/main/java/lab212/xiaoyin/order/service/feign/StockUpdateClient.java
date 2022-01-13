package lab212.xiaoyin.order.service.feign;

import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.order.service.feign.fallback.StockUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 00:41
 */
@FeignClient(value = "stock-update", fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);
}

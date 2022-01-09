package lab212.xiaoyin.fmmall.ordersubmit.service.feign;

import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback.StockUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 02:14
 */
@FeignClient(value = "stock-update", fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);
}

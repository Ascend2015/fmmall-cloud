package lab212.xiaoyin.fmmall.orderadd.feign;

import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.orderadd.feign.fallback.StockQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:28
 */
@FeignClient(value = "stock-query", fallback = StockQueryClientFallback.class)
public interface StockQueryClient {

    @GetMapping("/stock/query")
    public List<ShoppingCartVO> query(@RequestParam("cids") String cids);
}

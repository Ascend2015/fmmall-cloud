package lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.StockUpdateClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 02:15
 */
@Component
public class StockUpdateClientFallback implements StockUpdateClient {

    @Override
    public int update(List<ProductSku> skus) {
        System.out.println("stock-update fallback...");
        return 0;
    }
}

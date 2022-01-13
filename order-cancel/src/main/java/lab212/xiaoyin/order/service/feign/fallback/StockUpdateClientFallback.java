package lab212.xiaoyin.order.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.order.service.feign.StockUpdateClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 00:42
 */
@Component
public class StockUpdateClientFallback implements StockUpdateClient {
    @Override
    public int update(List<ProductSku> skus) {
        System.out.println("stock update failed in order-close");
        return 0;
    }
}

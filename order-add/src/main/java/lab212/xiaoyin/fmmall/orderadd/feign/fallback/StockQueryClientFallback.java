package lab212.xiaoyin.fmmall.orderadd.feign.fallback;

import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.orderadd.feign.StockQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:30
 */
@Component
public class StockQueryClientFallback implements StockQueryClient {
    @Override
    public List<ShoppingCartVO> query(String cids) {
        System.out.println("stock-query的服务降级。。。");
        return null;
    }
}

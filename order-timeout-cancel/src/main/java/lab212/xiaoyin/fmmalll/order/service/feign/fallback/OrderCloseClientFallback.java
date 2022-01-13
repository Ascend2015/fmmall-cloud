package lab212.xiaoyin.fmmalll.order.service.feign.fallback;

import lab212.xiaoyin.fmmalll.order.service.feign.OrderCloseClient;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 01:11
 */
@Component
public class OrderCloseClientFallback implements OrderCloseClient {
    @Override
    public int close(String orderId, int closeType) {
        System.out.println(" order cancel failed in timeout-cancel");
        return 0;
    }
}

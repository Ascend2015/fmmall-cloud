package lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.ShoppingCartVO;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.OrderItemAddClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 23:38
 */
@Component
public class OrderItemAddClientFallback implements OrderItemAddClient {
    @Override
    public int addOrderItem(List<ShoppingCartVO> list, String orderId) {
        System.out.println("orderItem add -----fallback");
        return 0;
    }
}

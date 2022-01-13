package lab212.xiaoyin.fmmalll.order.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.fmmalll.order.service.feign.OrderTimeoutQueryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 00:56
 */
@Component
public class OrderTimeoutQueryClientFallback implements OrderTimeoutQueryClient {
    @Override
    public List<Orders> query() {

        System.out.println("");
        return new ArrayList<>();
    }
}

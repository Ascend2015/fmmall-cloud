package lab212.xiaoyin.fmmall.ordersubmit.service.feign.fallback;

import lab212.xiaoyin.fmmall.ordersubmit.service.feign.ShopcartDelClient;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 02:20
 */
@Component
public class ShopcartDelClientFallback implements ShopcartDelClient {
    @Override
    public int del(String cids) {
        System.out.println("shopcart del fallback...");
        return 0;
    }
}

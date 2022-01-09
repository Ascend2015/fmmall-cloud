package lab212.xiaoyin.fmmall.ordersubmit.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 02:19
 */
@FeignClient("shopcart-del")
public interface ShopcartDelClient {

    @DeleteMapping("/shopcart/del")
    public int del(@RequestParam("cids") String cids);
}

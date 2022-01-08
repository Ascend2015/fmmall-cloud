package lab212.xiaoyin.api.service.feign;

import lab212.xiaoyin.api.service.feign.fallback.UserCheckClientFallback;
import lab212.xiaoyin.fmmall.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 00:38
 */
@FeignClient(value = "user-check",fallback = UserCheckClientFallback.class)
public interface UserCheckClient {

    @GetMapping("/user")
    public Users check(@RequestParam("username")String username);
}

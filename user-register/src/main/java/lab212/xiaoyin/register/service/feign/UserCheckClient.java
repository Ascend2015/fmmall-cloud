package lab212.xiaoyin.register.service.feign;

import lab212.xiaoyin.fmmall.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 17:51
 */
@FeignClient("user-check")
public interface UserCheckClient {

    @GetMapping("/user/check")
    public Users check(@RequestParam("username")String username);
}

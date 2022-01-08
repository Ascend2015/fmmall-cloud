package lab212.xiaoyin.register.service.feign;

import lab212.xiaoyin.fmmall.beans.Users;
import lab212.xiaoyin.register.service.feign.fallback.UserSaveClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 21:59
 */
@FeignClient(value = "user-save", fallback = UserSaveClientFallback.class)
public interface UserSaveClient {

    @PostMapping("/user/save")
    public int save(@RequestBody Users user);
}

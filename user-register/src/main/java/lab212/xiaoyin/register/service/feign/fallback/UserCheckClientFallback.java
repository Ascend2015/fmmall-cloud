package lab212.xiaoyin.register.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.Users;
import lab212.xiaoyin.register.service.feign.UserCheckClient;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 17:57
 */
@Component
public class UserCheckClientFallback implements UserCheckClient {
    @Override
    public Users check(String username) {
        return new Users();
    }
}

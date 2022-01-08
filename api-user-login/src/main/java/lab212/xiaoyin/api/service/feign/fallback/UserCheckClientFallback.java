package lab212.xiaoyin.api.service.feign.fallback;

import lab212.xiaoyin.api.service.feign.UserCheckClient;
import lab212.xiaoyin.fmmall.beans.Users;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 13:32
 */
@Component
public class UserCheckClientFallback implements UserCheckClient {
    @Override
    public Users check(String username) {
        return null;
    }
}

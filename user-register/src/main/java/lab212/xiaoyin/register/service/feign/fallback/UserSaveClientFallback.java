package lab212.xiaoyin.register.service.feign.fallback;

import lab212.xiaoyin.fmmall.beans.Users;
import lab212.xiaoyin.register.service.feign.UserSaveClient;
import org.springframework.stereotype.Component;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 22:01
 */
@Component
public class UserSaveClientFallback implements UserSaveClient {
    @Override
    public int save(Users user) {
        return 0;
    }
}

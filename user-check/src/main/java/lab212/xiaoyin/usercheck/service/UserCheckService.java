package lab212.xiaoyin.usercheck.service;

import lab212.xiaoyin.fmmall.entity.Users;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 23:06
 */
public interface UserCheckService {

    public Users queryUser(String name);
}

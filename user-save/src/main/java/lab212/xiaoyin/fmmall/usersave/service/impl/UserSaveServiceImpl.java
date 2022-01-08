package lab212.xiaoyin.fmmall.usersave.service.impl;

import lab212.xiaoyin.fmmall.entity.Users;
import lab212.xiaoyin.fmmall.usersave.dao.UserMapper;
import lab212.xiaoyin.fmmall.usersave.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 17:43
 */
@Service
public class UserSaveServiceImpl implements UserSaveService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Users user) {
        int i = userMapper.insertUseGeneratedKeys(user);
        return i;
    }
}

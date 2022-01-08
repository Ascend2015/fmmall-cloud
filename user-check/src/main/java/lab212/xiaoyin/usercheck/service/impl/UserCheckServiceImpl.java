package lab212.xiaoyin.usercheck.service.impl;

import lab212.xiaoyin.fmmall.entity.Users;
import lab212.xiaoyin.usercheck.dao.UserMapper;
import lab212.xiaoyin.usercheck.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 23:08
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users queryUser(String name) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}

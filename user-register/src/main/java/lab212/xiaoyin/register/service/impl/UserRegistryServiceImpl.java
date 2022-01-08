package lab212.xiaoyin.register.service.impl;

import lab212.xiaoyin.fmmall.beans.Users;
import lab212.xiaoyin.fmmall.utils.MD5Utils;
import lab212.xiaoyin.fmmall.vo.ResStatus;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import lab212.xiaoyin.register.service.UserRegistryService;
import lab212.xiaoyin.register.service.feign.UserCheckClient;
import lab212.xiaoyin.register.service.feign.UserSaveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 17:50
 */
@Service
public class UserRegistryServiceImpl implements UserRegistryService {

    @Autowired
    private UserCheckClient userCheckClient;

    @Autowired
    private UserSaveClient userSaveService;

    @Override
    public ResultVO registry(String name, String pwd) {
        synchronized (this) {
            //1.根据用户查询，这个用户是否已经被注册

            Users user = userCheckClient.check(name);

            //2.如果没有被注册则进行保存操作
            if (user == null) {
                String md5Pwd = MD5Utils.md5(pwd);
                user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = userSaveService.save(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功！", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败！", null);
                }
            } else if (user.getUsername() == null) {
                return new ResultVO(ResStatus.NO, "网络故障，请重试！", null);
            } else {
                return new ResultVO(ResStatus.NO, "用户名已被注册！", null);
            }
        }
    }
}

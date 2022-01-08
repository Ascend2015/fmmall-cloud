package lab212.xiaoyin.register.controller;

import lab212.xiaoyin.fmmall.beans.Users;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import lab212.xiaoyin.register.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 22:24
 */
@RestController
@CrossOrigin
public class UserRegistryController {

    @Autowired
    private UserRegistryService userRegistryService;

    @PostMapping("/user/registry")
    public ResultVO registry(Users user) {
        return userRegistryService.registry(user.getUsername(), user.getPassword());
    }
}

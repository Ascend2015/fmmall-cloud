package lab212.xiaoyin.usercheck.controller;

import lab212.xiaoyin.fmmall.entity.Users;
import lab212.xiaoyin.usercheck.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 23:05
 */
@RestController
@RequestMapping("/user")
public class UserCheckController {

    @Autowired
    private UserCheckService userCheckService;

    @GetMapping("/check")
    public Users  check(String username,String password) {
        return userCheckService.queryUser(username);
    }
}

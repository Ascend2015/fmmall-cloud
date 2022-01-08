package lab212.xiaoyin.fmmall.usersave.controller;

import lab212.xiaoyin.fmmall.entity.Users;
import lab212.xiaoyin.fmmall.usersave.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 17:45
 */
@RestController
@RequestMapping("/user")
public class UserSaveController {

    @Autowired
    private UserSaveService userSaveService;

    @PostMapping("/save")
    public int save(@RequestBody Users user) {
        return userSaveService.saveUser(user);
    }
}

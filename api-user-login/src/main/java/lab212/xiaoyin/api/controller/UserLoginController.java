package lab212.xiaoyin.api.controller;

import lab212.xiaoyin.api.service.UserLoginService;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 20:28
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;
    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);


    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam(value = "password") String pwd) {
        ResultVO resultVO = userLoginService.checkLogin(name, pwd);
        logger.info(resultVO.getMsg());
        return resultVO;
    }
}

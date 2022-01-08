package lab212.xiaoyin.api.service;

import lab212.xiaoyin.fmmall.vo.ResultVO;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 20:32
 */
public interface UserLoginService {

    public ResultVO checkLogin(String name, String pwd);
}

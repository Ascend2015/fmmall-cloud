package lab212.xiaoyin.fmmall.service;


import lab212.xiaoyin.fmmall.vo.ResultVO;

public interface UserService {

    //用户注册
    public ResultVO userResgit(String name, String pwd);

    //用户登录
    public ResultVO checkLogin(String name, String pwd);

}

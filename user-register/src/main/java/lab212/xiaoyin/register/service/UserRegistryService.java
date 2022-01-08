package lab212.xiaoyin.register.service;

import lab212.xiaoyin.fmmall.vo.ResultVO;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-05 17:48
 */
public interface UserRegistryService {

    public ResultVO registry(String name, String password);
}

package lab212.xiaoyin.usercheck.dao;

import lab212.xiaoyin.fmmall.entity.Users;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 23:09
 */
@Repository
public interface UserMapper extends Mapper<Users>, MySqlMapper<Users> {
}

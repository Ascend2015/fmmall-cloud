package lab212.xiaoyin.fmmall.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yinck
 */
public interface GeneralDAO<T> extends Mapper<T> , MySqlMapper<T> {
}

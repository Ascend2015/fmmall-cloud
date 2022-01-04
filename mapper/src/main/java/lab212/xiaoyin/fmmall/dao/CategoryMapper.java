package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.Category;
import lab212.xiaoyin.fmmall.entity.CategoryVO;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface CategoryMapper extends GeneralDAO<Category> {

    /**
     * 1.连接查询
     *
     * @return
     */
    public List<CategoryVO> selectAllCategories();

    /**
     * 2.子查询：根据parentId查询子分类
     *
     * @param parentId
     * @return
     */
    public List<CategoryVO> selectAllCategories2(int parentId);

    /**
     * 3.查询一级类别
     *
     * @return
     */
    public List<CategoryVO> selectFirstLevelCategories();

}

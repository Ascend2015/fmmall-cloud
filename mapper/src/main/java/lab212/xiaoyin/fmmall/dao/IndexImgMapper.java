package lab212.xiaoyin.fmmall.dao;


import lab212.xiaoyin.fmmall.entity.IndexImg;
import lab212.xiaoyin.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinck
 */
@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {

    /**
     * 1.查询轮播图信息： 查询status=1 且 按照seq进行排序
     *
     * @return
     */
    public List<IndexImg> listIndexImgs();

}
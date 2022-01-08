package lab212.xiaoyin.fmmall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import lab212.xiaoyin.fmmall.dao.CategoryMapper;
import lab212.xiaoyin.fmmall.beans.CategoryVO;
import lab212.xiaoyin.fmmall.service.CategoryService;
import lab212.xiaoyin.fmmall.vo.ResStatus;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 查询分类列表（包含三个级别的分类）
     *
     * @return
     */
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = null;
        try {
            String categories = stringRedisTemplate.opsForValue().get("categories");
            if (StringUtils.hasText(categories)) {
                JavaType categoriesType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, CategoryVO.class);
                categoryVOS = objectMapper.readValue(categories, categoriesType);
            } else {
                //如果redis没有类别数据
                categoryVOS = categoryMapper.selectAllCategories();
                stringRedisTemplate.boundValueOps("categories").set(objectMapper.writeValueAsString(categoryVOS), 1, TimeUnit.DAYS);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

    /**
     * 查询所有一级分类，同时查询当前一级分类下销量最高的6个商品
     *
     * @return
     */
    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

}

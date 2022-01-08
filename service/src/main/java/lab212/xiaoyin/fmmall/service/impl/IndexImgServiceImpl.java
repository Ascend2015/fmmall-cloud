package lab212.xiaoyin.fmmall.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab212.xiaoyin.fmmall.dao.IndexImgMapper;
import lab212.xiaoyin.fmmall.beans.IndexImg;
import lab212.xiaoyin.fmmall.service.IndexImgService;
import lab212.xiaoyin.fmmall.vo.ResStatus;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yinck
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = null;
        try {
            String imgsStr = stringRedisTemplate.opsForValue().get("indexImgs");
            if (StringUtils.hasText(imgsStr)) {
                JavaType indexImgsType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IndexImg.class);
                indexImgs = objectMapper.readValue(imgsStr, indexImgsType);
            } else {
                synchronized (this) {
                    String s = stringRedisTemplate.opsForValue().get("indexImgs");
                    if (s == null) {
                        indexImgs = indexImgMapper.listIndexImgs();
                        if (indexImgs != null) {
                            stringRedisTemplate.boundValueOps("indexImgs").set(objectMapper.writeValueAsString(indexImgs));
                            //设置过期时间
                            stringRedisTemplate.boundValueOps("indexImgs").expire(1, TimeUnit.DAYS);
                        } else {
                            List<IndexImg> arr = new ArrayList<>();
                            stringRedisTemplate.boundValueOps("indexImgs").set(objectMapper.writeValueAsString(arr));
                            //设置过期时间
                            stringRedisTemplate.boundValueOps("indexImgs").expire(10, TimeUnit.SECONDS);
                        }
                    } else {
                        JavaType indexImgsType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, IndexImg.class);
                        indexImgs = objectMapper.readValue(s, indexImgsType);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (indexImgs.size() == 0) {
            return new ResultVO(ResStatus.NO, "fail", null);
        } else {
            return new ResultVO(ResStatus.OK, "success", indexImgs);
        }
    }
}

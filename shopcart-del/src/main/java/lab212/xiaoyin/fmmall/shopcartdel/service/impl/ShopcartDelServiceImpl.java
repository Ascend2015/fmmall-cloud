package lab212.xiaoyin.fmmall.shopcartdel.service.impl;

import lab212.xiaoyin.fmmall.shopcartdel.dao.ShoppingCartMapper;
import lab212.xiaoyin.fmmall.shopcartdel.service.ShopcartDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:08
 */
@Service
public class ShopcartDelServiceImpl implements ShopcartDelService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public int deleteShopcart(String cids) {
        String[] arr = cids.split(",");
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            int cid = Integer.parseInt(arr[i]);
            int j = shoppingCartMapper.deleteByPrimaryKey(cid);
            k*=j;
        }
        return k;
    }
}

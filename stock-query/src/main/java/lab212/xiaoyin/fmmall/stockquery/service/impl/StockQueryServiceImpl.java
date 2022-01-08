package lab212.xiaoyin.fmmall.stockquery.service.impl;

import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.stockquery.dao.ShopCartMapper;
import lab212.xiaoyin.fmmall.stockquery.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 02:10
 */
@Service
public class StockQueryServiceImpl implements StockQueryService {

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public List<ShoppingCartVO> selectShopcartByCids(String cids) {
        String[] arr = cids.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cartIds.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shopCartMapper.selectShopcartByCids(cartIds);
        return list;
    }
}

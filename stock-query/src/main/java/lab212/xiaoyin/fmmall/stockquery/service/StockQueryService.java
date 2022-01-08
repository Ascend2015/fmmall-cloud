package lab212.xiaoyin.fmmall.stockquery.service;

import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 02:09
 */
public interface StockQueryService {

    public List<ShoppingCartVO> selectShopcartByCids(String cids);
}

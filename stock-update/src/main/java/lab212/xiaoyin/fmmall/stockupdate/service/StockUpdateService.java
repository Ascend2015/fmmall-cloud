package lab212.xiaoyin.fmmall.stockupdate.service;

import lab212.xiaoyin.fmmall.entity.ProductSku;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:56
 */
public interface StockUpdateService {

    public int updateStock(List<ProductSku> skus);
}

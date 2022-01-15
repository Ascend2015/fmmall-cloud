package lab212.xiaoyin.fmmall.stockupdate.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import lab212.xiaoyin.fmmall.entity.ProductSku;
import lab212.xiaoyin.fmmall.stockupdate.dao.ProductSkuMapper;
import lab212.xiaoyin.fmmall.stockupdate.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:57
 */
@Service
public class StockUpdateServiceImpl implements StockUpdateService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    @Override
    public int updateStock(List<ProductSku> skus) {
        int j = 1;
        for (ProductSku sku : skus) {
            int i = productSkuMapper.updateByPrimaryKeySelective(sku);
            j *= i;
        }
        return j;
    }
}

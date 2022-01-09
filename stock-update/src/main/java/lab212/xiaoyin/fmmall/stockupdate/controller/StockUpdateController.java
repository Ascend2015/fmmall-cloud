package lab212.xiaoyin.fmmall.stockupdate.controller;

import lab212.xiaoyin.fmmall.entity.ProductSku;
import lab212.xiaoyin.fmmall.stockupdate.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 15:55
 */
@RestController
public class StockUpdateController {

    @Autowired
    private StockUpdateService stockUpdateService;

    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus){
        return stockUpdateService.updateStock(skus);
    }
}

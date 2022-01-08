package lab212.xiaoyin.fmmall.stockquery.controller;

import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import lab212.xiaoyin.fmmall.stockquery.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 02:20
 */
@RestController
public class StockQueryController {

    @Autowired
    private StockQueryService stockQueryService;

    @GetMapping("/stock/query")
    public List<ShoppingCartVO> query(String cids) {
        List<ShoppingCartVO> list = stockQueryService.selectShopcartByCids(cids);
        return list;
    }
}

package lab212.xiaoyin.fmmall.orderadd.service;

import lab212.xiaoyin.fmmall.entity.Orders;
import lab212.xiaoyin.fmmall.entity.ShoppingCartVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:24
 */
public interface OrderAddService {

    public List<ShoppingCartVO> save(@RequestBody Orders order, String cids);
}

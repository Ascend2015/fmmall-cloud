package lab212.xiaoyin.fmmall.ordersubmit.service.impl;

import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.fmmall.beans.ShoppingCartVO;
import lab212.xiaoyin.fmmall.ordersubmit.service.OrderSubmitService;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.OrderAddClient;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.OrderItemAddClient;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.ShopcartDelClient;
import lab212.xiaoyin.fmmall.ordersubmit.service.feign.StockUpdateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 18:23
 */
@Service
public class OrderSubmitServiceImpl implements OrderSubmitService {

    @Autowired
    private OrderAddClient orderAddClient;

    @Autowired
    private OrderItemAddClient orderItemAddClient;

    @Autowired
    private StockUpdateClient stockUpdateClient;

    @Autowired
    private ShopcartDelClient shopcartDelClient;

    @Override
    public Map<String, String> addOrder(String cid, Orders order) {
        String orderId = UUID.randomUUID().toString().replace("-", "");
        order.setOrderId(orderId);
        List<ShoppingCartVO> carts = orderAddClient.saveOrder(order, cid);
        Map<String, String> map = null;
        if (carts != null) {
            int i = orderItemAddClient.addOrderItem(carts, orderId);
            if (i > 0) {
                List<ProductSku> skus = new ArrayList<>();
                for (ShoppingCartVO sc : carts) {
                    String skuId = sc.getSkuId();
                    int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                    ProductSku productSku = new ProductSku();
                    productSku.setSkuId(skuId);
                    productSku.setStock(newStock);
                    skus.add(productSku);
                }
                int j = stockUpdateClient.update(skus);
                //删除购物车
                if (j > 0) {
                    int k = shopcartDelClient.del(cid);
                    if (k > 0) {
                        map = new HashMap<>();
                        map.put("orderId", orderId);
                        String str = "";
                        for (int index = 0; index < carts.size(); index++) {
                            str += carts.get(index).getSkuName();
                            str = index == carts.size() - 1 ? str : str + ",";
                        }
                        map.put("productName", str);
                    }
                }
            }
        }
        return map;
    }
}

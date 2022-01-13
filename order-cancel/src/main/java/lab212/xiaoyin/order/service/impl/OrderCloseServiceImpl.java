package lab212.xiaoyin.order.service.impl;

import lab212.xiaoyin.fmmall.beans.OrderItem;
import lab212.xiaoyin.fmmall.beans.Orders;
import lab212.xiaoyin.fmmall.beans.ProductSku;
import lab212.xiaoyin.order.service.OrderCloseService;
import lab212.xiaoyin.order.service.feign.OrderItemQueryClient;
import lab212.xiaoyin.order.service.feign.OrderStatusUpdateClient;
import lab212.xiaoyin.order.service.feign.ProductSkuQueryClient;
import lab212.xiaoyin.order.service.feign.StockUpdateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:22
 */
@Service
public class OrderCloseServiceImpl implements OrderCloseService {

    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;

    @Autowired
    private OrderItemQueryClient orderItemQueryClient;

    @Autowired
    private ProductSkuQueryClient productSkuQueryClient;

    @Autowired
    private StockUpdateClient stockUpdateClient;

    @Override
    public int closeOrder(String orderId, int closeType) {
        //1.修改订单状态
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setStatus("6");
        order.setCloseType(closeType);
        int i = orderStatusUpdateClient.update(order);
        int j=0;
        if (i > 0) {
            //2.查询订单下商品快照
            List<OrderItem> orderItems = orderItemQueryClient.query(orderId);
            //3.还原库存
            if (orderItems != null && orderItems.size() > 0) {
                List<ProductSku> skus = new ArrayList<>();
                for (OrderItem item : orderItems) {
                    String skuId = item.getSkuId();
                    //查询套餐信息
                    ProductSku sku = productSkuQueryClient.query(skuId);
                    int newStock = sku.getStock() + item.getBuyCounts();
                    sku.setStock(newStock);
                    skus.add(sku);
                }
                j = stockUpdateClient.update(skus);
            }
        }

        return j;
    }
}

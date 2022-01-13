package lab212.xiaoyin.order.service;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-09 22:21
 */
public interface OrderCloseService {

    public int closeOrder(String orderId,int closeType);
}

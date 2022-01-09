package lab212.xiaoyin.fmmall.ordersubmit.service;

import lab212.xiaoyin.fmmall.beans.Orders;

import java.util.Map;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 18:21
 */
public interface OrderSubmitService {

    public Map<String,String> addOrder(String cid, Orders order);
}

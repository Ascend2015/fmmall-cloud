package lab212.xiaoyin.fmmall.ordersubmit.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-13 15:00
 */
@Service
public class SendMsg2MqService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String orderId) {
        amqpTemplate.convertAndSend("ex6", "key1", orderId);
    }
}

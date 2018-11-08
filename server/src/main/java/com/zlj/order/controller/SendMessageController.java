package com.zlj.order.controller;

import com.zlj.order.dto.OrderDTO;
import com.zlj.order.message.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-19 14:48
 * @description
 */
@RestController
public class SendMessageController {

    @Autowired
    private Source source;

    /**
     * 发送orderdto对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        //source.output().send(MessageBuilder.withPayload("now" + new Date()).build());
        source.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}

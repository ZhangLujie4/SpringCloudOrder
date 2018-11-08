package com.zlj.order.message;

import com.zlj.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-19 14:46
 * @description
 */

@Component
@EnableBinding({Sink.class,Source.class})
@Slf4j
public class StreamReceiver {

//    @StreamListener("input")
//    public void process(String message) {
//        log.info("StreamReceiver: {}", message);
//    }

    /**
     * 接受orderDTO对象
     * @param message
     */
    @StreamListener("input")
    @SendTo("output2")
    public String process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }

    @StreamListener("input2")
    public void process2(String message) {
        log.info("StreamReceiver: {}", message);
    }
}

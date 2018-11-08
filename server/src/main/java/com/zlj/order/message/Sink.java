package com.zlj.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-19 16:00
 * @description
 */
public interface Sink {

    @Input("input")
    SubscribableChannel input();

    @Input("input2")
    SubscribableChannel input2();
}

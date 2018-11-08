package com.zlj.order.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-19 15:59
 * @description
 */
public interface Source {

    @Output("output")
    MessageChannel output();

    @Output("output2")
    MessageChannel output2();
}

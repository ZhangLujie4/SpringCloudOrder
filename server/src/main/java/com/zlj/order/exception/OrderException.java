package com.zlj.order.exception;

import com.zlj.order.enums.ResultEnum;

/**
 * @author tori
 * 2018/8/6 下午3:59
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}

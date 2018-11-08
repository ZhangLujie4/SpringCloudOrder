package com.zlj.order.enums;

import lombok.Getter;

/**
 * @author tori
 * 2018/8/6 下午4:01
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),

    CART_EMPTY(2, "购物车不能为空"),

    ORDER_NOT_EXIST(3, "订单不存在"),

    ORDER_STATUS_ERROR(4, "订单状态异常"),

    ORDER_DETAIL_NOT_DETAIL(5, "订单详情不存在")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

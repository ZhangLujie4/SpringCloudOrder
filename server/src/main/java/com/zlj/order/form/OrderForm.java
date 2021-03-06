package com.zlj.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author tori
 * 2018/8/6 下午3:53
 */

@Data
public class OrderForm {


    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "电话不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "openid不能为空")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}

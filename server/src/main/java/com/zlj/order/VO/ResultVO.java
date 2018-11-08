package com.zlj.order.VO;

import lombok.Data;

/**
 *
 * http请求返回的最外层对象
 * @author tori
 * 2018/8/6 下午1:52
 */

@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}

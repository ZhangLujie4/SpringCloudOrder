package com.zlj.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tori
 * @description
 * @date 2018/9/4 下午1:29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private String productId;

    private Integer productQuantity;
}

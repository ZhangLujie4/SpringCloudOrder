package com.zlj.order.service;

import com.zlj.order.dto.OrderDTO;

/**
 * @author tori
 * 2018/8/6 下午3:23
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单
     * 只能卖家来操作
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}

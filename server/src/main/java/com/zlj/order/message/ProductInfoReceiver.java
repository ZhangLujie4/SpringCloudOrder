package com.zlj.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zlj.order.utils.JsonUtil;
import com.zlj.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-20 15:48
 * @description
 */

@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        //message => ProductInfoOutput
//        ProductInfoOutput productInfoOutput = (ProductInfoOutput) JsonUtil.fromJson(message, ProductInfoOutput.class);
//        log.info("从队列{}接收到消息：{}", "productInfo", productInfoOutput);

//        //存储到redis中
//        stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
//                String.valueOf(productInfoOutput.getProductStock()));
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列{}接收到消息：{}", "productInfo", productInfoOutputList);

        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}

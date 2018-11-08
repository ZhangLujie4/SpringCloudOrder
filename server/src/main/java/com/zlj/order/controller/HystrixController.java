package com.zlj.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-26 15:11
 * @description
 */

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //@HystrixCommand(fallbackMethod = "fallback")
    /**
     * 超时配置
     */
//    @HystrixCommand(commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })

    /**
     * 熔断配置
     * @return
     */
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求数达到后才计算
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //错误率
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number) {

        if (number % 2 == 0) {
            return "success";
        }

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8084/product/listForOrder",
                Arrays.asList("157875196366160022"), String.class);
        /**
         * 在这里抛异常是不会显示在前端的
         * 降级不只在异常处理
         */
        // throw new RuntimeException("发送异常了");
    }

    private String fallback() {
        return "太拥挤了，请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认提示，太拥挤了，请稍后再试";
    }
}

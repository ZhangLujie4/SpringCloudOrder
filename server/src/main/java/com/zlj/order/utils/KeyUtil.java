package com.zlj.order.utils;

import java.util.Random;

/**
 * @author tori
 * 2018/8/6 下午3:36
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式 时间戳+随机数
     */

    public static synchronized String genUniqueKey() {

        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

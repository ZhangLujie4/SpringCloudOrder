package com.zlj.order.controller;

import com.zlj.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMZ
 * @description
 */

@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {

        return girlConfig.getName() + " " + girlConfig.getAge();
    }
}

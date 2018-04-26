package com.demo.imooc.service.impl;

import com.demo.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 **/

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        //greeting
        System.out.println("Hello greeting ....");
        return "hello " + name;
    }

}

package com.demo.imooc.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * Crete by Marlon
 * Create Date: 2018/5/2
 * Class Describe
 **/
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户的信息  默认创建用户 并返回用户唯一标识
        return connection.getDisplayName();
    }

}

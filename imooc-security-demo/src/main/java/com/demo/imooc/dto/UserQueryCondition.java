package com.demo.imooc.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Crete by Marlon
 * Create Date: 2018/3/29
 * Class Describe
 **/

public class UserQueryCondition {

    private String username;

    @ApiModelProperty(value = "起始页")
    private int age;

    @ApiModelProperty(value = "终止页")
    private int ageTo;

    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return "UserQueryCondition{" +
                       "username='" + username + '\'' +
                       ", age=" + age +
                       ", ageTo=" + ageTo +
                       ", xxx='" + xxx + '\'' +
                       '}';
    }

}

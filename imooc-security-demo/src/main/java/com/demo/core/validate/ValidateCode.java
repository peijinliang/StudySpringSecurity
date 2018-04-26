package com.demo.core.validate;

import java.time.LocalDateTime;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 * 验证码
 **/
public class ValidateCode {

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;


    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }


    public ValidateCode(String code, int expireIn) {
        this.code = code;
        //当前时间 +   过期时间  =  截止时间
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    /**
     * 是否超时
     * 当前时间 在 过期时间  之后 ： 表示过期
     * 当前时间 在过期时间   之前 ：未过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "ImageCode{" +
                       ", code='" + code + '\'' +
                       ", expireTime=" + expireTime +
                       '}';
    }


}

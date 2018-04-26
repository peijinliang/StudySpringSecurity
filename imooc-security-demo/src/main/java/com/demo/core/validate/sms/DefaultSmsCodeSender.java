package com.demo.core.validate.sms;

/**
 * Crete by Marlon
 * Create Date: 2018/4/25
 * Class Describe
 **/

public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }

}

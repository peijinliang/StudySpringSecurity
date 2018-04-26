package com.demo.core.validate.sms;

/**
 * Crete by Marlon
 * Create Date: 2018/4/25
 * Class Describe
 **/
public interface SmsCodeSender {

    void send(String mobile, String code);

}

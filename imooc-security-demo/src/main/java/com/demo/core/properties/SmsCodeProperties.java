package com.demo.core.properties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 **/

public class SmsCodeProperties {

    private int length = 4;
    private int expireIn = 60;

    private String url;

    public SmsCodeProperties() {

    }

    public SmsCodeProperties(int length) {
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageCodeProperties{" +
                       ", length=" + length +
                       ", expireIn=" + expireIn +
                       '}';
    }


}

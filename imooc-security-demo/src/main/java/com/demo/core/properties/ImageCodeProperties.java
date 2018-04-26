package com.demo.core.properties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 **/

public class ImageCodeProperties extends SmsCodeProperties {

    private int with = 67;
    private int height = 23;

    public ImageCodeProperties() {
        super(4);
    }


    private String url;

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "ImageCodeProperties{" +
                       "with=" + with +
                       ", height=" + height +
                       '}';
    }


}

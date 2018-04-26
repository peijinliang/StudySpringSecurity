package com.demo.browser.support;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe
 **/

public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SimpleResponse{" + "content=" + content + '}';
    }

}

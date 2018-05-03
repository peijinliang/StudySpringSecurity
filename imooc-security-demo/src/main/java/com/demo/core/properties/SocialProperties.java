package com.demo.core.properties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/28
 * Class Describe
 **/

public class SocialProperties {

    private QQProperties qq = new QQProperties();

    private String filterProcessUrl = "/auth";

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }


    public String getFilterProcessUrl() {
        return filterProcessUrl;
    }

    public void setFilterProcessUrl(String filterProcessUrl) {
        this.filterProcessUrl = filterProcessUrl;
    }

    @Override
    public String toString() {
        return "SocialProperties{" +
                       "qq=" + qq +
                       '}';
    }
}

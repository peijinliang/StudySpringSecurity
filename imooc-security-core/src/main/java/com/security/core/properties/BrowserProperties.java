package com.security.core.properties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe
 **/
public class BrowserProperties {

    private String loginPage = "/imooc-sigin.html";


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public String toString() {
        return "BrowserProperties{" +
                       "loginPage='" + loginPage + '\'' +
                       '}';
    }
}

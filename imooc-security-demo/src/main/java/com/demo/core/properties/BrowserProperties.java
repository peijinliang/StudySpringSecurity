package com.demo.core.properties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe
 **/
public class BrowserProperties {

    /**
     * 用户配置用用户配置的
     * 用户没有配置用默认的
     */
    private String loginPage = "/imooc-sigin.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }


    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }


    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    @Override
    public String toString() {
        return "BrowserProperties{" + "loginPage='" + loginPage + '\'' + '}';
    }

}


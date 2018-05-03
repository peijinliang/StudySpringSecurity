package com.demo.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe
 *
 * 获取以com.security 开头的配置项
 **/
@ConfigurationProperties(prefix = "com.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();


    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}

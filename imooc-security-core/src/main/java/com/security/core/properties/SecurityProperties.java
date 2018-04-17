package com.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe
 **/

@ConfigurationProperties(prefix = "com.security")
public class SecurityProperties {

    private BrowserProperties browserProperties = new BrowserProperties();


    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}

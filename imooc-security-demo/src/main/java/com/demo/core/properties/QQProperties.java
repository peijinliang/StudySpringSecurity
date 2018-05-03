package com.demo.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Crete by Marlon
 * Create Date: 2018/4/28
 * Class Describe
 **/

public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

}

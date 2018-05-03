package com.demo.browser.support;

/**
 * Crete by Marlon
 * Create Date: 2018/5/2
 * Class Describe
 **/
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickName;

    private String headimg;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    @Override
    public String toString() {
        return "SocialUserInfo{" +
                       "providerId='" + providerId + '\'' +
                       ", providerUserId='" + providerUserId + '\'' +
                       ", nickName='" + nickName + '\'' +
                       ", headimg='" + headimg + '\'' +
                       '}';
    }
}

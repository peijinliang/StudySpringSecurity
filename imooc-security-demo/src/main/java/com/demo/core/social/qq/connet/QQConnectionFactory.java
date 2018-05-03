package com.demo.core.social.qq.connet;

import com.demo.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * Crete by Marlon
 * Create Date: 2018/4/28
 * Class Describe
 **/

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    /**
     * @param providerId
     * @param appId
     * @param appSecret
     */
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQadapter());
    }

}

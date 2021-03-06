package com.demo.core.social.qq.connet;

import com.demo.core.social.qq.api.QQ;
import com.demo.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import java.io.IOException;

/**
 * Crete by Marlon
 * Create Date: 2018/4/28
 * Class Describe
 **/
public class QQadapter implements ApiAdapter<QQ> {

    /**
     * 测试当前API是否可用
     *
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    /**
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = null;
        userInfo = api.getQQUserInfo();
        //用户姓名
        values.setDisplayName(userInfo.getNickname());
        //头像
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        //个人博客
        values.setProfileUrl(null);
        //openId
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {
        // do nothing
    }


}

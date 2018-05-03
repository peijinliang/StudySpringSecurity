package com.demo.browser.controller;

import com.demo.browser.support.SimpleResponse;
import com.demo.browser.support.SocialUserInfo;
import com.demo.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe 通过Controller 进行配置
 **/

@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 请求缓存
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     *
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ProviderSignInUtils providerSignInUtils;


    /**
     * 当需要身份认证的时候跳转到这里
     * UNAUTHORIZED(401, "Unauthorized")
     * 返回一个状态码
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是:", targetUrl);
            //如果引发的请求时HTML
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                //跳转到某一个登录页
                System.out.println("----------------" + securityProperties.getBrowser().getLoginPage());
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }


    @GetMapping("/social/user")
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();

        Connection<?> connections = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));

        userInfo.setProviderUserId(connections.getKey().getProviderUserId());
        userInfo.setProviderId(connections.getKey().getProviderId());
        userInfo.setHeadimg(connections.getImageUrl());
        userInfo.setNickName(connections.getDisplayName());

        return userInfo;
    }


}

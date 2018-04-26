package com.demo.browser.auth;

import com.demo.core.properties.LoginType;
import com.demo.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 * <p>
 * 登录成功之后调用
 * 1、 AuthenticationSuccessHandler  实现接口
 * 2、SavedRequestAwareAuthenticationSuccessHandler 默认的
 **/

@Component("imoocAuthenticationSuccessHandler")
public class ImoocAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 把一个对象转换成json字符串
     */
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");

        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8 ");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }

    /**
     * 反馈回的信息authentication 内容：
     * {
     authorities: [{
     authority: "admin"
     }],
     details: {
     remoteAddress: "0:0:0:0:0:0:0:1",
     sessionId: "032A1FF2AAC0F4E681212F0F3E2371F7"
     },
     authenticated: true,
     principal: {
     password: null,
     username: "admin",
     authorities: [{
     authority: "admin"
     }],
     accountNonExpired: true,
     accountNonLocked: true,
     credentialsNonExpired: true,
     enabled: true
     },
     credentials: null,
     name: "admin"
     }
     */

}

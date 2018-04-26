package com.demo.core.validate;

import org.springframework.web.context.request.ServletWebRequest;


/**
 * Crete by Marlon
 * Create Date: 2018/4/25
 * Class Describe
 * 校验码处理器 ，封装不同的校验码的处理器
 **/

public interface ValidateCodeProcessor {

    /**
     * 验证码放入Session时的前缀
     */
    String SESSION_KEY_PREFIX = "SEESION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * ServletWebRequest   封装请求和相应的包装类： request 和 response
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

}

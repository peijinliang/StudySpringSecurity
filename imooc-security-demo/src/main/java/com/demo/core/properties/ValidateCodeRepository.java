package com.demo.core.properties;

import com.demo.core.validate.ValidateCodeType;
import com.demo.core.validate.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Crete by Marlon
 * Create Date: 2018/4/25
 * Class Describe
 **/
public interface  ValidateCodeRepository {

    /**
     * 保存验证码
     * @param request
     * @param code
     * @param validateCodeType
     */
    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

    /**
     * 获取验证码
     * @param request
     * @param validateCodeType
     * @return
     */
    ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

    /**
     * 移除验证码
     * @param request
     * @param codeType
     */
    void remove(ServletWebRequest request, ValidateCodeType codeType);


}

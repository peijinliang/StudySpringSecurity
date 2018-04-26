package com.demo.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 **/

public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}

package com.demo.core.validate;

import    org.springframework.security.core.AuthenticationException;
/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe Validate  code   Exception
 **/
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}

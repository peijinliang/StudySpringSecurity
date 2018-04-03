package com.imooc.web.controller;

import com.imooc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 * ֻҪ�׳����쳣 UserNotExistException  ��Ĭ��ȥ�����÷���
 **/
@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUseNotExistException(UserNotExistException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("message", e.getMessage());
        return map;
    }

}

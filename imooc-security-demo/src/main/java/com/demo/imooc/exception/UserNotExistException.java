package com.demo.imooc.exception;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 **/

public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("user is not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

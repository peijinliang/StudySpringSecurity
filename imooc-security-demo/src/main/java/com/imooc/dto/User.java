package com.imooc.dto;

/**
 * Crete by Marlon
 * Create Date: 2018/3/29
 * Class Describe
 **/
public class User {

    private String password;
    private String username;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                       "password='" + password + '\'' +
                       ", username='" + username + '\'' +
                       '}';
    }
}

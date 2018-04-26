package com.demo.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.demo.imooc.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Crete by Marlon
 * Create Date: 2018/3/29
 * Class Describe
 **/

public class User {

    public interface UserSimpleView {

    }

    public interface UserDetailView extends UserSimpleView {

    }

    @NotBlank(message = "密码不能为空")
    private String password;

    @MyConstraint(message = "用户名不能为空")
    private String username;

    private String id;

    @Past(message = "生日日期")
    private Date birthday;

    public User() {

    }

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "User{" +
                       "password='" + password + '\'' +
                       ", username='" + username + '\'' +
                       ", id='" + id + '\'' +
                       ", birthday=" + birthday +
                       '}';
    }

}

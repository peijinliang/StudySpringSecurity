package com.demo.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.demo.imooc.dto.User;
import com.demo.imooc.dto.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 2018/3/29
 * Class Describe
 **/

@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * if (StringUtils.isEmpty(user.getBirthday())) {
     * }
     */
    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println("resources/error" + error.getDefaultMessage()));
        }
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        System.out.println(user.getId());
        user.setId("1");
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@PathVariable(name = "id") String id, @Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() + "     " + error.getDefaultMessage();
                System.out.println(message);
            });
        }
        System.out.println(id);
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        user.setId("1");
        return user;
    }


    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable(name = "id") String id) {
        System.out.println("delete  id :" + id);
    }


    /**
     * @param username
     * @param pageable
     * @return
     * @RequestMapping(value = "/user", method = RequestMethod.GET)
     * @GetMapping(value = "/user")
     */
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam(required = false, name = "username", defaultValue = "no values") String username, @PageableDefault(size = 10, page = 1, sort = "usernane,asc") Pageable pageable) {
        System.out.println("username------" + username);
        System.out.println("page:size ------" + pageable.getPageSize());
        System.out.println("page number------" + pageable.getPageNumber());
        System.out.println("sort----" + pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User("xiaoming", "123123"));
        users.add(new User("xiaoming", "123123"));
        users.add(new User("xiaoming", "123123"));

        return users;
    }

    /**
     * @param condition
     * @return
     * @RequestMapping(value = "/users", method = RequestMethod.GET)
     * @GetMapping(value = "/users")
     */
    @GetMapping(value = "/users")
    @JsonView(User.UserDetailView.class)
    @ApiOperation(value = "获取用户列表")
    public List<User> query(UserQueryCondition condition) {
        System.out.println("condition------" + condition);
        List<User> users = new ArrayList<>();
        users.add(new User("xiaoming", "123123"));
        users.add(new User("xiaohong", "123123"));
        users.add(new User("xiaohua", "123123"));
        return users;
    }

    /**
     * PathVariable
     * URL
     * @param id
     * @return
     * @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
     * @GetMapping(value = "/users")
     */
    @GetMapping(value = "/{id:\\d+}")
    public User getInfo(@ApiParam(value = "用户ID") @PathVariable(name = "id") String id) {
        System.out.println("Controller ");

//      throw new UserNotExistException(id);
//      throw new RuntimeException("what fuck the line?");

        System.out.println("Controller id-----" + id);
        User user = new User();
        user.setUsername("tom");
        user.setPassword("234234");
        return user;
    }


}

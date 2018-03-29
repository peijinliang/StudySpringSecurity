package com.imooc;

import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Crete by Marlon
 * Create Date: 2018/3/29
 * Class Describe
 **/

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam(required = false, name = "username", defaultValue = "no values") String username, @PageableDefault(size = 10, page = 1, sort = "usernane,asc") Pageable pageable) {
        System.out.println("username------：" + username);
        System.out.println("page:size ------：" + pageable.getPageSize());
        System.out.println("page number------：" + pageable.getPageNumber());
        System.out.println("sort-----：" + pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    //直接传递对象
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> query(UserQueryCondition condition) {
        System.out.println("condition------：" + condition);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }


}

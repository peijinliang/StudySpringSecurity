package com.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Crete by Marlon
 * Create Date: 2018/4/11
 * Class Describe
 **/

@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("-------------------" + username);
        // 每一次加密结果都不一样
        String password = passwordEncoder.encode("123456");
        logger.info("-------------------" + password);
        // User  实现了   UserDetails 接口  如果校验都通过则把 信息放到session中去
        return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    /**
     * 实际的业务逻辑中就是控制表的字段 来判断当前用户的登录状态
     * enabled 是否可用
     * accountNonExpired  账号 过期
     * credentialsNonExpired 认证过期
     * accountNonLocked    账号没有被锁住
     */

}

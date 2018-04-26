package com.demo.browser;

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
        // ÿһ�μ��ܽ������һ��
        String password = passwordEncoder.encode("123456");
        logger.info("-------------------" + password);
        // User  ʵ����   UserDetails �ӿ�  ���У�鶼ͨ����� ��Ϣ�ŵ�session��ȥ
        return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    /**
     * ʵ�ʵ�ҵ���߼��о��ǿ��Ʊ���ֶ� ���жϵ�ǰ�û��ĵ�¼״̬
     * enabled               �Ƿ����
     * accountNonExpired     �˺� ����
     * credentialsNonExpired ��֤����
     * accountNonLocked      �˺�û�б���ס
     */

}

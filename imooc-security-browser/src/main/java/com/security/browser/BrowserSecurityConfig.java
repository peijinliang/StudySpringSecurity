package com.security.browser;

import com.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Crete by Marlon
 * Create Date: 2018/4/4
 * Class Describe
 * Component
 * 通过web的请求，进行过滤配置  对于部分的请求进行验证
 **/

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 自己写的加密方法
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("------------------运行：", "BrowserSecurityConfig");
        // http.formLogin()  表单认证
        // httpBasic()  // httpBasic http认证
        http.formLogin()
                .loginPage("/imooc-sigin.html")
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()  //authorize 授权请求
                .antMatchers("/imooc-sigin.html", securityProperties.getBrowserProperties().getLoginPage()).permitAll()
                .anyRequest()         //所有的请求
                .authenticated() //authenticated  已认证
                .and()
                .csrf().disable();  //否则报错 Could not verify the provided CSRF token because your session was not found.
        // 配置HTTP请求
        //super.configure(http);
    }

}

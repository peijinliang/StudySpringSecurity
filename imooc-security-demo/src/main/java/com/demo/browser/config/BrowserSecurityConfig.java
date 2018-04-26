package com.demo.browser.config;

import com.demo.browser.auth.ImoocAuthenticationFailureHandler;
import com.demo.browser.auth.ImoocAuthenticationSuccessHandler;
import com.demo.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.demo.core.properties.SecurityProperties;
import com.demo.core.validate.SmsCodeFilter;
import com.demo.core.validate.ValidateCodeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import javax.sql.DataSource;

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

    @Autowired
    private ImoocAuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private ImoocAuthenticationFailureHandler imoocAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //系统启动时 默认创建这个表
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

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
        logger.info("------------------运行:", "BrowserSecurityConfig");
        // http.formLogin()  表单认证
        // httpBasic()
        // httpBasic http认证
        //登录 页面
        //当访问这个URL的时候不需要身份认证
        //loginProcessingUrl

        //验证码过滤器
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        //验证失败管理
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        //验证码过滤器
        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        //验证失败管理
        smsCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();

        //在某一个过滤器之前加 过滤器
        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(imoocAuthenticationSuccessHandler)
                .failureHandler(imoocAuthenticationFailureHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()  //authorize 授权请求
                .antMatchers("/authentication/require", "/code/*", securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()         //所有的请求
                .authenticated() //authenticated  已认证
                .and()
                .csrf()
                .disable()// 跨站防护伪造功能
                .apply(smsCodeAuthenticationSecurityConfig);
        //否则报错 Could not verify the provided CSRF token because your session was not found
        // 配置HTTP请求
        //super.configure(http);
    }

}

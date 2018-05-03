package com.demo.core.social;

import com.demo.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;
import javax.sql.DataSource;

/**
 * Crete by Marlon
 * Create Date: 2018/4/28
 * Class Describe
 **/

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    //jdbcUsersConnectionRepository.setConnectionSignUp();

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;


    /**
     * Default implementation of {@link #getUsersConnectionRepository(ConnectionFactoryLocator)} that creates an in-memory repository.
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("security_");

        if(connectionSignUp != null){
            repository.setConnectionSignUp(connectionSignUp);
        }

        // Encryptors  加解密
        return repository;
    }

    @Bean
    public SpringSocialConfigurer imoocSocialSecurityConfig() {
        ImoocSpringSocialConfigurer imoocSpringSocialConfigurer = new ImoocSpringSocialConfigurer(securityProperties.getSocial().getFilterProcessUrl());
        imoocSpringSocialConfigurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return imoocSpringSocialConfigurer;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator));
    }




}

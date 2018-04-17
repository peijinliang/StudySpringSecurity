package com.security.core;

import com.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Crete by Marlon
 * Create Date: 2018/4/17
 * Class Describe
 **/

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {


}

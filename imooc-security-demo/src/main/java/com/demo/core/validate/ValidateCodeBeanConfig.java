package com.demo.core.validate;

import com.demo.core.properties.SecurityProperties;
import com.demo.core.validate.image.ImageCodeGenerator;
import com.demo.core.validate.sms.DefaultSmsCodeSender;
import com.demo.core.validate.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 为什么要这样写,原因是：容器里是否有一个名字叫：imageCodeGenerator 的Bean
     * 如果在容器中找到就不创建了；
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }


}

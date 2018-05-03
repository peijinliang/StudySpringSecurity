package com.demo.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Crete by Marlon
 * Create Date: 2018/4/28
 * Class Describe
 **/
public class ImoocSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessUrl;

    public ImoocSpringSocialConfigurer(String filterProcessUrl){
        this.filterProcessUrl = filterProcessUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess( object);
        filter.setFilterProcessesUrl(filterProcessUrl);
        return (T) filter;
    }


}

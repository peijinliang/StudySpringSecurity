package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.iterceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 * 第三方 的过滤器 没有@Component 注解 但是又想将其加入进来springboot中来，我们应该如何处理？
 **/

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{


    @Autowired
    private TimeInterceptor timeIntercepter;

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(timeIntercepter);
    }


    /**
     * 配置异步线程
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        //注册 Callable 拦截器
//        configurer.registerCallableInterceptors();
//        //注册 DeferredResult 拦截器
//        configurer.registerDeferredResultInterceptors();
//        //异步请求默认超时时间
//        configurer.setDefaultTimeout(11000);
//        //设置spring 不是默认的线程池
//        configurer.setTaskExecutor(new AsyncTaskExecutor() {
//            @Override
//            public void execute(Runnable task) {
//
//            }
//
//            @Override
//            public void execute(Runnable task, long startTimeout) {
//
//            }
//
//            @Override
//            public Future<?> submit(Runnable task) {
//                return null;
//            }
//
//            @Override
//            public <T> Future<T> submit(Callable<T> task) {
//                return null;
//            }
//        });
        super.configureAsyncSupport(configurer);
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        List<String> usrs = new ArrayList<>();
        usrs.add("/*");

        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);
        filterRegistrationBean.setUrlPatterns(usrs);
        return filterRegistrationBean;
    }



}

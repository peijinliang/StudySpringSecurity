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
 * ������ �Ĺ����� û��@Component ע�� �������뽫��������springboot����������Ӧ����δ���
 **/

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{


    @Autowired
    private TimeInterceptor timeIntercepter;

    /**
     * ע��������
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(timeIntercepter);
    }


    /**
     * �����첽�߳�
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        //ע�� Callable ������
//        configurer.registerCallableInterceptors();
//        //ע�� DeferredResult ������
//        configurer.registerDeferredResultInterceptors();
//        //�첽����Ĭ�ϳ�ʱʱ��
//        configurer.setDefaultTimeout(11000);
//        //����spring ����Ĭ�ϵ��̳߳�
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
     * ������
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

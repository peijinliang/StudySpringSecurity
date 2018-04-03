package com.imooc.web.iterceptor;

import com.sun.xml.internal.ws.resources.HandlerMessages;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor  preHandle");

        System.out.println("interceptor ������: " + ((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println("interceptor ������: " + ((HandlerMethod) handler).getMethod());

        request.setAttribute("startTime", new Date().getTime());
        return true; // false  ������֮��ķ���   true ��������֮��ķ���
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor postHandle");
        long start = (long) request.getAttribute("startTime");
        System.out.println("time interceptor ��ʱ:" + (new Date().getTime() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("interceptor  afterCompletion");
        long start = (long) request.getAttribute("startTime");
        System.out.println("time interceptor ��ʱ:" + (new Date().getTime() - start));
        System.out.println("interceptor  ex is " + ex);
    }


}
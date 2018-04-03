package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Crete by Marlon
 * Create Date: 2018/4/3
 * Class Describe
 **/
@Aspect
@Component
public class TimeAspect {

//    @Before("切片之前")
//    @After("前片执行之后")
//    @Around("整个过程  平时用这个")

    /**
     * 第一个 *  代表任何返回值   第二个*  代表任何方法  。。 代表任何参数
     * spring  文档： https://docs.spring.io/spring/docs/4.3.14.RELEASE/spring-framework-reference/htmlsingle/#aop-pointcuts
     * 过滤器 拦截器  都拿不到参数
     */
    @Around("execution(*  com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect  start");

        //获取参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is" + arg);
        }

        long start = new Date().getTime();

        //执行控制器中被拦截的方法、得到返回值object
        Object object = pjp.proceed();

        System.out.println("time aspect  耗时" + (new Date().getTime() - start));

        System.out.println("time aspect  end");
        return object;
    }


}

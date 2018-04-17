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

//    @Before("��Ƭ֮ǰ")
//    @After("ǰƬִ��֮��")
//    @Around("��������  ƽʱ�����")

    /**
     * https://docs.spring.io/spring/docs/4.3.14.RELEASE/spring-framework-reference/htmlsingle/#aop-pointcuts
     */
    @Around("execution(*  com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect  start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is" + arg);
        }

        long start = new Date().getTime();
        Object object = pjp.proceed();
        System.out.println("time aspect coast" + (new Date().getTime() - start));
        System.out.println("time aspect  end");

        return object;
    }


}

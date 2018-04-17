package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 * 过滤器
 **/

//@Component  采用另一种配置方式
public class TimeFilter implements Filter {

    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    //处理过滤逻辑
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter  耗时:" + (new Date().getTime() - start));
        System.out.println("time filter finish");
    }

    //销毁
    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }


}

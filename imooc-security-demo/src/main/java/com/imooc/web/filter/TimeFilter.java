package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 * ������
 **/

//@Component  ������һ�����÷�ʽ
public class TimeFilter implements Filter {

    //��ʼ��
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    //��������߼�
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter  ��ʱ:" + (new Date().getTime() - start));
        System.out.println("time filter finish");
    }

    //����
    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }


}

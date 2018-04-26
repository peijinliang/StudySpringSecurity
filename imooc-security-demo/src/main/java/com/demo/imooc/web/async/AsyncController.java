package com.demo.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.concurrent.Callable;

/**
 * Crete by Marlon
 * Create Date: 2018/4/3
 * Class Describe
 **/

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    /**
     * 测试一个同步用例
     */
    @RequestMapping("/order")
    public String order() throws Exception {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程返回");
        return "success";
    }

    /**
     * 测试一个异步用例 Runable接口
     * 业务逻辑的处理放到付副线程里来
     */
    @RequestMapping("/orders")
    public Callable<String> orders() throws Exception {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");
                return "success";
            }
        };
        logger.info("主线程返回");
        return result;
    }

    /**
     * orderslist
     * @return
     * @throws Exception
     */
    @RequestMapping("/orderslist")
    public DeferredResult<String> orderslist() throws Exception {
        logger.info("主线程开始");

        //生成一个八位数的随机数
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrer(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        logger.info("主线程返回");
        deferredResultHolder.getMap().put(orderNumber, result);

        return result;
    }


}

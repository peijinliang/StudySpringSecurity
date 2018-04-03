package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Crete by Marlon
 * Create Date: 2018/4/3
 * Class Describe
 **/
@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String placeOrer;

    private String completeOrer;

    public String getPlaceOrer() {
        return placeOrer;
    }

    public void setPlaceOrer(String placeOrer) throws InterruptedException {
      new Thread(()->{
          logger.info("�ӵ��µ����� " + placeOrer);
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          this.completeOrer = placeOrer;
          logger.info("�µ���������ϣ� " + completeOrer);
      });
    }

    public String getCompleteOrer() {
        return completeOrer;
    }

    public void setCompleteOrer(String completeOrer) {
        this.completeOrer = completeOrer;
    }


    @Override
    public String toString() {
        return "MockQueue{" +
                       "placeOrer='" + placeOrer + '\'' +
                       ", completeOrer='" + completeOrer + '\'' +
                       '}';
    }


}

package com.demo.imooc.code;

import com.demo.core.validate.image.ImageCode;
import com.demo.core.validate.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Crete by Marlon
 * Create Date: 2018/4/24
 * Class Describe
 * imageCodeGenerator
 **/

//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的方式生成验证码:报空指针");
        return null;
    }


}

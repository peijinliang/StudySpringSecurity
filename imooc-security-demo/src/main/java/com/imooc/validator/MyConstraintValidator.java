package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 * Constraint 约束
 * Validator 校验
 * Object 为校验参数的类型
 **/

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    //注入进行校验
    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init ");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        System.out.println(value);
        //true 为校验成功  false 校验失败
        return false;
    }

//    my validator init
//    Hello greeting ....
//    birthday     生日必须是过去的时间
//    password     密码不能为空
//    username     这是一个测试 校验

}

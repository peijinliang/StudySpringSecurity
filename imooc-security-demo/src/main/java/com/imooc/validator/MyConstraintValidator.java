package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 * Constraint Լ��
 * Validator У��
 * Object ΪУ�����������
 **/

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    //ע�����У��
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
        //true ΪУ��ɹ�  false У��ʧ��
        return false;
    }

//    my validator init
//    Hello greeting ....
//    birthday     ���ձ����ǹ�ȥ��ʱ��
//    password     ���벻��Ϊ��
//    username     ����һ������ У��

}

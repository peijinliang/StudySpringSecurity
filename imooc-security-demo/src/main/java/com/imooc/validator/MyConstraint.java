package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Crete by Marlon
 * Create Date: 2018/4/2
 * Class Describe
 **/

@Target({ElementType.METHOD ,ElementType.FIELD})  //����У�� �ֶ�У��
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public  @interface MyConstraint {

    //һ���������Ա���Ҫ��
    String message() ;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

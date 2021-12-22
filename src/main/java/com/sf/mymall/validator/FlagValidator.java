package com.sf.mymall.validator;

import org.apache.catalina.User;

import javax.swing.text.Element;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class) //验证逻辑类,可以多个值
public @interface FlagValidator {
    String[] value() default {};
    String message() default "flag not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

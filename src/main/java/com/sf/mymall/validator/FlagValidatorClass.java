package com.sf.mymall.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Integer> {
    //第一个泛型为验证注解类型，第二个泛型为验证的数据类型，一般设置为Object
    private String[] values;//用来接收验证注解里的值

    @Override
    public void initialize(FlagValidator args) {
        this.values = args.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        for (int i=0;i<this.values.length;i++){
            if(this.values[i].equals(String.valueOf(value))){
                return true;
            }
        }
        return false;
    }
}

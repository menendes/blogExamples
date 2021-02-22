package com.training.zib.training.util.validator;

import com.training.zib.training.customAnnotation.Username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username,String> {

    private String usernamePrefix;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if(username != null){
          result = username.startsWith(usernamePrefix);
        }

        /*if(!result){
            String err = "There is a error";
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(err).addConstraintViolation();
        }*/

        return result;
    }

    @Override
    public void initialize(Username constraintAnnotation) {
        this.usernamePrefix = constraintAnnotation.value();
    }
}

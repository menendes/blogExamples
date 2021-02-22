package com.training.zib.training.util.validator;

import com.training.zib.training.enumeration.UserRole;
import com.training.zib.training.customAnnotation.CheckRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<CheckRole, UserRole> {

   // private UserRole userRole;

    @Override
    public boolean isValid(UserRole role, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if(role != null){
            switch (role){
                case USER :
                case ADMIN:
                    result = true;
                    break;
                default:
                    result = false;
            }
        }
        return result;
    }

    @Override
    public void initialize(CheckRole constraintAnnotation) {
           // this.userRole = constraintAnnotation.value();
    }
}

package com.training.zib.training.customAnnotation;


import com.training.zib.training.enumeration.UserRole;
import com.training.zib.training.util.validator.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CheckRole {

    UserRole value() default UserRole.USER;

    String message() default "Invalid user role.";

    Class<?>[] groups() default  {};

    Class<? extends Payload>[] payload() default  {};

}

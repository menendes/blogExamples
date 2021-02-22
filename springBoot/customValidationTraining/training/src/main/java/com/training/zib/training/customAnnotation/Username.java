package com.training.zib.training.customAnnotation;

import com.training.zib.training.util.validator.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Size(min = 5,max = 25,message = "Username size can have min 5 char, max 25 char")
@Constraint(validatedBy = UsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Username {

    String value() default "zib";

    String message() default "Invalid username";

    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default  {};
}

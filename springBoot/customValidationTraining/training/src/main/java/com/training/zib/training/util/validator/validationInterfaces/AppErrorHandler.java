package com.training.zib.training.util.validator.validationInterfaces;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;

public interface AppErrorHandler<T> extends Payload {
    void onError (ConstraintViolation<T> violation);
}

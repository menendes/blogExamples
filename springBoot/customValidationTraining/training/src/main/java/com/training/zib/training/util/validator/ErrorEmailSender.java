package com.training.zib.training.util.validator;

import com.training.zib.training.util.validator.validationInterfaces.AppErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;

public class ErrorEmailSender<T> implements AppErrorHandler<T> {

    Logger logger = LoggerFactory.getLogger(ErrorEmailSender.class);

    @Override
    public void onError(ConstraintViolation<T> violation) {
        logger.error("Sending email to support team: " +
                violation.getPropertyPath() + " " +
                violation.getMessage());
    }
}

package com.training.zib.training.test;

import com.training.zib.training.entity.User;
import com.training.zib.training.enumeration.UserRole;
import com.training.zib.training.util.validator.validationInterfaces.AdvanceInfo;
import com.training.zib.training.util.validator.validationInterfaces.AppErrorHandler;
import com.training.zib.training.util.validator.validationInterfaces.BasicInfo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class UserTest {

    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void basicInfoGroupsTest() {
        User user = buildUser();

        Set<ConstraintViolation<User>> violations = validator.validate(user, BasicInfo.class);
        Assert.assertEquals(violations.size(),2);


    }

    @Test
    public void advanceInfoGroupTest() {
        User user = buildUser();
        Set<ConstraintViolation<User>> violations = validator.validate(user, AdvanceInfo.class);
        Assert.assertEquals(violations.size(),1);

    }

    private User buildUser() {
        User user = new User();
        user.setName("padawan");
        user.setUsername("cptpepper");
        user.setUserRole(UserRole.ADMIN);
        return user;
    }

    //below the codes related payload property in the custom annotation interface
    @Test
    public void userPayloadValidationTest(){
        User user = buildUser();
        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate(user,AdvanceInfo.class);
        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    UserTest::processError);
        }
    }

    private static void processError (ConstraintViolation<User> violation) {
        Set<Class<? extends Payload>> payload =
                violation.getConstraintDescriptor().getPayload();
        payload.forEach(p -> {
            if (AppErrorHandler.class.isAssignableFrom(p)) {
                try {
                    AppErrorHandler errorHandler = (AppErrorHandler) p.newInstance();
                    errorHandler.onError(violation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package com.training.zib.training.entity;

import com.training.zib.training.enumeration.UserRole;
import com.training.zib.training.customAnnotation.CheckRole;
import com.training.zib.training.customAnnotation.Username;
import com.training.zib.training.util.validator.ErrorEmailSender;
import com.training.zib.training.util.validator.validationInterfaces.AdvanceInfo;
import com.training.zib.training.util.validator.validationInterfaces.BasicInfo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Username(groups = {BasicInfo.class},payload = ErrorEmailSender.class)
    private String name;


    @Username(groups = {AdvanceInfo.class},payload = ErrorEmailSender.class)
    private String username;

    @CheckRole(groups = BasicInfo.class)
    private UserRole userRole;

}

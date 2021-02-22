package com.training.zib.training.controller;

import com.training.zib.training.entity.User;
import com.training.zib.training.service.UserServiceImpl;
import com.training.zib.training.util.validator.validationInterfaces.AdvanceInfo;
import com.training.zib.training.util.validator.validationInterfaces.BasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@Validated({BasicInfo.class, AdvanceInfo.class}) @RequestBody User user){
        User response = userService.addUser(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getUser(){
        List<User> userList = userService.getAllUsers();
         return ResponseEntity.ok(userList);
    }

}

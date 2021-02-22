package com.training.zib.training.service;

import com.training.zib.training.entity.User;

import java.util.List;

public interface UserService {

   public abstract User addUser(User user);
   public abstract List<User> getAllUsers();
}

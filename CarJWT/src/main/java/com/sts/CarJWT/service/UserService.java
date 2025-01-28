package com.sts.CarJWT.service;


import com.sts.CarJWT.dto.UserDto;
import com.sts.CarJWT.entity.User;

import java.util.List;

public interface UserService {

    // Saves a user
    UserDto save(UserDto user);

    // Retrieves all users
    List<User> findAll();

    // Retrieves a user by username
    User findOne(String username);

}
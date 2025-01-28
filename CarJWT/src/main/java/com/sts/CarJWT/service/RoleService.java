package com.sts.CarJWT.service;


import com.sts.CarJWT.entity.Role;

// Declaring the RoleService interface
public interface RoleService {
    // Method to find a Role by its name
    Role findByName(String name);
}

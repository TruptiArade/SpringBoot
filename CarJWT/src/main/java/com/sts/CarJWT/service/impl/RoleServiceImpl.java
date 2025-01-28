package com.sts.CarJWT.service.impl;


import com.sts.CarJWT.Repository.RoleRepository;
import com.sts.CarJWT.entity.Role;
import com.sts.CarJWT.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        // Find role by name using the roleDTO
        Role role = roleRepository.findRoleByName(name);
        return role;
    }
}

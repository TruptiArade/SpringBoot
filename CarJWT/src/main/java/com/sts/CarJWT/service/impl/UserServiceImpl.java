package com.sts.CarJWT.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sts.CarJWT.Repository.UserRepository;
import com.sts.CarJWT.customexception.UserAlreadyExistsException;
import com.sts.CarJWT.dto.UserDto;
import com.sts.CarJWT.entity.Role;
import com.sts.CarJWT.entity.User;
import com.sts.CarJWT.service.RoleService;
import com.sts.CarJWT.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    // Load user by username
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    // Get user authorities
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    // Find all users
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    // Find user by username
    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }


    // Save user
    @Override
    public UserDto save(UserDto userDto)
    {

        // Check if username already exists
        if (userRepository.findByUsername(userDto.getUsername()) != null)
        {
            throw new UserAlreadyExistsException("Username already exists!");
        }
        userDto.getUsername();
        userDto.getPassword();
        userDto.getEmail();
        userDto.getPhone();
        userDto.getName();

        User nUser = modelMapper.map(userDto,User.class);
        nUser.setPassword(bcryptEncoder.encode(userDto.getPassword()));

        // Set default role as USER
        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        // If email domain is admin.edu, add ADMIN role
        if(nUser.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);


        // Save the user entity to the repository
        User savedUser = userRepository.save(nUser);

        // Map the saved entity back to DTO
        return modelMapper.map(savedUser, UserDto.class);
    }

}
package com.sts.CarJWT.controller;


import com.sts.CarJWT.config.TokenProvider;
import com.sts.CarJWT.dto.UserDto;
import com.sts.CarJWT.entity.AuthToken;
import com.sts.CarJWT.entity.LoginUser;
import com.sts.CarJWT.entity.User;
import com.sts.CarJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

   //Authenticate User/Admin
    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

   //Register the user or admin
    @PostMapping("/register")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }


    //Admin Read
    @GetMapping("/adminping")
    public String adminPing() {
        return "Only Admins Can Read This";
    }

    //User Read
    @GetMapping("/userping")
    public String userPing() {
        return "Any User Can Read This";
    }

    //Get All User Data
    @GetMapping("/find/all")
    public List<User> getAllList() {
        return userService.findAll();
    }

    //Get All User Data based on username
    @GetMapping("/find/by/username")
    public User getAllList(@RequestParam String username) {
        return userService.findOne(username);
    }
}

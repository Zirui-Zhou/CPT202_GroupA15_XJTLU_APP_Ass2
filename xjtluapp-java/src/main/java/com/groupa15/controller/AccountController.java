package com.groupa15.controller;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.common.lang.Response;
import com.groupa15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    //@Autowired
    //JwtUtils jwtUtils;

    @PostMapping("/login")
    // Response
    public Boolean login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) {
        return userService.loginUser(loginDto.getUsername(),
                loginDto.getPassword()) != null;
    }

    @PostMapping("/register")
    public void register(@Validated @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) {
        userService.registerUser(loginDto.getUsername(),
                loginDto.getPassword());
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

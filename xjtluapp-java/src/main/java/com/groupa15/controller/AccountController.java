package com.groupa15.controller;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.common.lang.Response;
import com.groupa15.entity.User;
import com.groupa15.service.UserService;
import com.groupa15.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Response login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = userService.loginUser(loginDto);
        String jwt = jwtUtils.generateToken(user.getUserId());
        response.setHeader(jwtUtils.getHeader(), jwt);
        return Response.success(HttpStatus.OK, user.getUserName());
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    public Response logout(HttpServletRequest httpServletRequest) {
        SecurityUtils.getSubject().logout();
        return Response.success(HttpStatus.OK, SecurityUtils.getSubject().toString());
    }

    @PostMapping("/register")
    public Response register(@Validated @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) {
        userService.registerUser(loginDto.getUsername(), loginDto.getPassword());
        return Response.success(HttpStatus.OK, loginDto.getUsername());
    }

}

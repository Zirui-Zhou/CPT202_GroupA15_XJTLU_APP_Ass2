package com.groupa15.controller;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.common.lang.Response;
import com.groupa15.entity.User;
import com.groupa15.service.UserService;
import com.groupa15.utils.JwtUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    // Response
    public Response login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = userService.loginUser(loginDto.getUsername(), loginDto.getPassword());
        // TODO(Zirui): Figure out the breaking point of the global exception handler.
        String jwt = jwtUtils.generateToken(user.getUserId());
        response.setHeader(jwtUtils.getHeader(), jwt);
        response.setHeader("Access-control-Expose-Headers", jwtUtils.getHeader());

        return Response.succ(HttpStatus.OK, user.getUsername(), null);
    }

    @PostMapping("/register")
    public Response register(@Validated @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) {
        userService.registerUser(loginDto.getUsername(), loginDto.getPassword());
        return Response.succ(HttpStatus.OK, loginDto.getUsername(), null);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

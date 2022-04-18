package com.groupa15.controller;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.common.Response;
import com.groupa15.common.dto.PasswordChangeDto;
import com.groupa15.entity.User;
import com.groupa15.entity.vo.UserInfoVO;
import com.groupa15.service.UserService;
import com.groupa15.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
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
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        UserInfoVO userInfoVO = userService.getUserInfoByUserId(user.getUserId());
        return Response.success(HttpStatus.OK, "Login Successfully", userInfoVO);
    }

    @GetMapping("/auth")
    public Response isAuth() {
        return Response.success(HttpStatus.OK, null, true);
    }

    @GetMapping("/user/info")
    public Response getUserInfo(@RequestHeader(value = "Authorization") String token) {
        Long userId = jwtUtils.getUserIdByToken(token);
        UserInfoVO userInfoVO = userService.getUserInfoByUserId(userId);
        return Response.success(HttpStatus.OK, null, userInfoVO);
    }

    @GetMapping(value="/user/info", params = "id")
    public Response getEditorInfo(@RequestParam(name = "id") Long userId) {
        UserInfoVO userInfoVO = userService.getUserInfoByUserId(userId);
        return Response.success(HttpStatus.OK, null, userInfoVO);
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    public Response logout(HttpServletRequest httpServletRequest) {
        SecurityUtils.getSubject().logout();
        return Response.success(HttpStatus.OK, SecurityUtils.getSubject().toString());
    }

    @PostMapping("/register")
    public Response register(@Validated @RequestBody LoginDto loginDto) {
        userService.registerUser(loginDto.getUsername(), loginDto.getPassword());
        return Response.success(HttpStatus.OK, loginDto.getUsername());
    }

    @PostMapping("/user/change_password")
    public Response changePassword(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody PasswordChangeDto passDto) {
        userService.changePassword(passDto, jwtUtils.getUserIdByToken(token));
        return Response.success(HttpStatus.OK, "Change password successfully");
    }

}

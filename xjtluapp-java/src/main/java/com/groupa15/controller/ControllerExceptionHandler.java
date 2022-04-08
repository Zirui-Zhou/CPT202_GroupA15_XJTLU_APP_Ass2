package com.groupa15.controller;

import com.groupa15.common.Response;
import org.apache.shiro.authc.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

/*
    TODO(Zirui): According to https://stackoverflow.com/questions/48584175/controlleradvice-doesnt-handle-exceptions,
     the ControllerAdvice cannot catch the exceptions on the servlet level. One possible solution is to override the advice
     filter in the low level which can cause fatal problem. Another is to prehandle the response in the shiro class to get
     formatted response.
 */

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnknownAccountException.class)
    public Response handler(UnknownAccountException e) {
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = LockedAccountException.class)
    public Response handler(LockedAccountException e) {
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public Response handler(IncorrectCredentialsException e) {
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response handler(MethodArgumentNotValidException e) {
        return Response.fail(HttpStatus.BAD_REQUEST, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /*
        TODO(Zirui): Add more `ExceptionHandler`.
     */

}

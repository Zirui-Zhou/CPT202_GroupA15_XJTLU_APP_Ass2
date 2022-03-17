package com.groupa15.common.exception;

import com.groupa15.common.lang.Response;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

/*
TODO(Zirui): Some conclusion: According to https://stackoverflow.com/questions/48584175/controlleradvice-doesnt-handle-exceptions,
    the ControllerAdvice cannot catch the exceptions on the servlet level. One possible solution is to override the advice
    filter in the low level which can cause fatal problem. Another is to prehandle the response in the shiro class to get
    formatted response.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnknownAccountException.class)
    public Response handler(UnknownAccountException e) {
//        log.error("UnknownAccountException: ", e);
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = LockedAccountException.class)
    public Response handler(LockedAccountException e) {
//        log.error("LockedAccountException: ", e);
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ExpiredCredentialsException.class)
    public Response handler(ExpiredCredentialsException e) {
//        log.error("ExpiredCredentialsException: ", e);
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public Response handler(IncorrectCredentialsException e) {
//        log.error("IncorrectCredentialsException: ", e);
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = JwtException.class)
    public Response handler(JwtException e) {
//        log.error("JwtException: ", e);
        return Response.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = AuthenticationException.class)
    public Response handler(AuthenticationException e) {
//        log.error("AuthenticationException: ", e);
        return Response.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    // TODO(Zirui): Add more `ExceptionHandler`.

}

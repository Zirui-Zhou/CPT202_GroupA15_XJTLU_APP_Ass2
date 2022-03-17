package com.groupa15.common.exception;

import com.groupa15.common.lang.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnknownAccountException.class)
    public Response handler(UnknownAccountException e) {
        log.error("UnknownAccountException: ", e);
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = LockedAccountException.class)
    public Response handler(LockedAccountException e) {
        log.error("LockedAccountException: ", e);
        return Response.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    // TODO(Zirui): Add more `ExceptionHander`.

}

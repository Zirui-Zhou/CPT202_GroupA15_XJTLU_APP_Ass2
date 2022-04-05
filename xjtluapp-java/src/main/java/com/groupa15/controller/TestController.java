package com.groupa15.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/again")
    @RequiresAuthentication
    public String helloagain() {
        return "hello again";
    }

}

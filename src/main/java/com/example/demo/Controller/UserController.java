package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
//add the prefix to this interface
public class UserController {

    @Autowired
    //import other class
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    //get: front end requests data from the back end
    public List<User> index(){
        User user = new User();
        List<User> all = userMapper.findAll();
        return all;
    }

    @PostMapping
    //post: front end sends data to the back end
    //RequestBody convert type of json to java
    public int save(@RequestBody User user){

        return userService.save(user);
    }
}

package com.example.demo.controller;

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

    @Autowired //import other class
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping //get: front end requests data from the back end
    public List<User> index(){
        return userMapper.findAll();
    }

    @PostMapping
    //post: front end sends data to the back end
    //RequestBody convert type of json to java
    public int save(@RequestBody User user){
        return userService.save(user);
    }

    //delete data by some param
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    //page query
    @GetMapping("/page")
    public List<User> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return userService.findPage(pageNum, pageSize);
    }
}

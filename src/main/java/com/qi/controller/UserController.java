package com.qi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qi.entity.User;
import com.qi.mapper.UserMapper;
import com.qi.service.UserService;
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
//    public List<User> findAll(){
//        return userMapper.findAll();
//    }
    public List<User> findAll(){
        return userService.list();
    }

    @PostMapping
    //post: front end sends data to the back end
    //RequestBody convert type of json to java
    public boolean saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //delete data by some param
    @DeleteMapping("/{id}")
//    public int delete(@PathVariable Integer id){
//        return userMapper.deleteById(id);
//    }
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    //page query
    @GetMapping("/page")
//    public List<User> findPage(@RequestParam Integer pageNum,
//                               @RequestParam Integer pageSize,
//                               @RequestParam String username){
//        return userService.findPage(pageNum, pageSize, username);
//    }
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam (defaultValue = "") String username){
        return userService.findPage(pageNum, pageSize, username);
    }

}

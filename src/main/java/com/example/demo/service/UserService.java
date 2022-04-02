package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        if(user.getId() == null){
            return userMapper.insert(user);
        }
        else{
            return userMapper.update(user);
        }
    }

    public List<User> findPage(Integer pageNum, Integer pageSize){
        if(pageNum < 1) return null;

        pageNum = (pageNum - 1) * pageSize;
        return userMapper.selectPage(pageNum, pageSize);
    }


}

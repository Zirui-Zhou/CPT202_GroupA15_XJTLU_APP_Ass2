package com.qi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qi.entity.User;
import com.qi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user){
//        if(user.getId() == null){
//            return userMapper.insert(user);
//        }
//        else{
//            return userMapper.update(user);
//        }
//    }

    //mybatis-plus 实现
    public boolean saveUser(User user){
        return saveOrUpdate(user);
    }


//    public List<User> findPage(Integer pageNum, Integer pageSize, String username){
//        if(pageNum != 0){
//            pageNum = (pageNum - 1) * pageSize;
//        }
//        username = "%" + username + "%";
//        return userMapper.findPage(pageNum, pageSize, username);
//    }

    public IPage<User> findPage(Integer pageNum, Integer pageSize, String username){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //如果不判断，会将""作为查询条件，将无法查询到此值为null的数据
        if(!username.equals("")) wrapper.like("username", username);

        return page(page, wrapper);
    }

}

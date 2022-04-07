package com.groupa15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.common.dto.LoginDto;
import com.groupa15.entity.User;
import com.groupa15.mapper.UserMapper;
import com.groupa15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserId(int userId) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void registerUser(String username, String password) {

    }

    @Override
    public User loginUser(LoginDto loginDto) {
        return null;
    }

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

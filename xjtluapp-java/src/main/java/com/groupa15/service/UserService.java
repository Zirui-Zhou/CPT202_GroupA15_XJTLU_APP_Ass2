package com.groupa15.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {

    User getUserByUserId(int userId);
    User getUserByUsername(String username);
    void registerUser(String username, String password);
    User loginUser(LoginDto loginDto);
    boolean saveUser(User user);
    IPage<User> findPage(Integer pageNum, Integer pageSize, String username);

}

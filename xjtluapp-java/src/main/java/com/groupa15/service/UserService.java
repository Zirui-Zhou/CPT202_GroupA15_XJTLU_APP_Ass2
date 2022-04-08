package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.entity.User;

/**
 * @author Qi Xu
 * @date 2022/3/15
 */

public interface UserService extends IService<User> {

    User getUserByUserId(Long userId);
    User getUserByUsername(String username);
    boolean registerUser(String username, String password);
    User loginUser(LoginDto loginDto);

}

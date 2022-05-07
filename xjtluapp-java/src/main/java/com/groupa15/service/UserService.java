package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.groupa15.entity.dto.LoginDto;
import com.groupa15.entity.dto.PasswordChangeDto;
import com.groupa15.entity.User;
import com.groupa15.entity.vo.UserInfoVO;

/**
 * @author Qi Xu
 * @date 2022/3/15
 */

public interface UserService extends IService<User> {

    User getUserByUserId(Long userId);

    User getUserByUsername(String username);

    UserInfoVO getUserInfoByUserId(Long userId);

    boolean registerUser(String username, String password);

    User loginUser(LoginDto loginDto);

    void updateUser(User user);

    void changePassword(PasswordChangeDto passDto, Long userId);
}

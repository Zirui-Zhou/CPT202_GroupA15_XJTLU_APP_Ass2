package com.groupa15.service;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.entity.User;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

public interface UserService {
    User getUserByUserId(int userId);
    User getUserByUsername(String username);
    void registerUser(String username, String password);
    User loginUser(LoginDto loginDto);
}

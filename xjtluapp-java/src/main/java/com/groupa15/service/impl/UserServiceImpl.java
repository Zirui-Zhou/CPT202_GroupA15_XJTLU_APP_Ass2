package com.groupa15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.common.dto.LoginDto;
import com.groupa15.common.dto.PasswordChangeDto;
import com.groupa15.entity.User;
import com.groupa15.entity.vo.UserInfoVO;
import com.groupa15.mapper.UserMapper;
import com.groupa15.service.UserService;
import com.groupa15.utils.SecureUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qi Xu
 * @date 2022/3/15
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecureUtils secureUtils;

    @Override
    public User getUserByUserId(Long userId) {
        User user = getById(userId);
        if(null == user) {
            throw new UnknownAccountException("The account does not exist.");
        }
        return user;
    }

    @Override
    public User getUserByUsername(String userName) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, userName);
        User user = this.getOne(wrapper);

        if(user == null) {
            throw new UnknownAccountException("The account does not exist.");
        }

        return user;
    }

    @Override
    public UserInfoVO getUserInfoByUserId(Long userId) {
        UserInfoVO userInfoVO = userMapper.selectUserInfoVoByUserId(userId);

        if(userInfoVO == null) {
            throw new UnknownAccountException("The account does not exist.");
        }

        return userInfoVO;
    }

    @Override
    public boolean registerUser(String username, String password) {
        String salt = secureUtils.getSalt();
        String hashedPassword = secureUtils.getHashedPassword(password, salt);
        User user = new User()
                .setUserName(username)
                .setPassword(hashedPassword)
                .setSalt(salt);
        return this.save(user);
    }

    @Override
    public User loginUser(LoginDto loginDto) {
        User user = this.getUserByUsername(loginDto.getUsername());
        String hashedPassword = secureUtils.getHashedPassword(loginDto.getPassword(), user.getSalt());
        if(!user.getPassword().equals(hashedPassword)) {
            throw new IncorrectCredentialsException("Password is not correct.");
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserId, user.getUserId());
        this.update(user, wrapper);
    }

    @Override
    public void changePassword(PasswordChangeDto passDto, Long userId) {

        User user = this.getUserByUserId(userId);
        String hashedOldPassword = secureUtils.getHashedPassword(passDto.getOldPassword(), user.getSalt());
        if(!user.getPassword().equals(hashedOldPassword)) {
            throw new IncorrectCredentialsException("Old password is not correct.");
        }

        String salt = secureUtils.getSalt();
        String hashedNewPassword = secureUtils.getHashedPassword(passDto.getNewPassword(), salt);
        User newUser = new User()
                .setUserId(userId)
                .setPassword(hashedNewPassword)
                .setSalt(salt);
       this.updateUser(newUser);
    }

}

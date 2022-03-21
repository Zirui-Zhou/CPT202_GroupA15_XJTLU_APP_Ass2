package com.groupa15.service.impl;

import com.groupa15.common.dto.LoginDto;
import com.groupa15.entity.User;
import com.groupa15.repo.UserRepo;
import com.groupa15.service.UserService;
import com.groupa15.utils.SecureUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SecureUtils secureUtils;

    /*
        TODO(Zirui): Attempt to dismiss the dependency of shiro, i.e. shiroException.
     */

    @Override
    public User getUserByUserId(int userId) {
        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty()) {
            throw new UnknownAccountException("The account does not exist.");
        }
        return user.get();
    }

    @Override
    public User getUserByUsername(String username){
        User user = userRepo.findOneByUsername(username);
        if(user == null) {
            throw new UnknownAccountException("The account does not exist.");
        }
        return user;
    }

    /*
        TODO(Zirui): Check the account conflicts
     */

    @Override
    public void registerUser(String username, String password) {
        String salt = secureUtils.getSalt();
        String hashedPassword = secureUtils.getHashedPassword(password, salt);
        User user = new User()
                .setUsername(username)
                .setPassword(hashedPassword)
                .setSalt(salt);
        userRepo.save(user);
    }

    @Override
    public User loginUser(LoginDto loginDto) {
        User user = getUserByUsername(loginDto.getUsername());
        String hashedPassword = secureUtils.getHashedPassword(loginDto.getPassword(), user.getSalt());
        if(!user.getPassword().equals(hashedPassword)) {
            throw new IncorrectCredentialsException("Password is not correct.");
        }
        return user;
    }
}

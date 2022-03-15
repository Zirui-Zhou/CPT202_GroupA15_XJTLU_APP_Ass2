package com.groupa15.service.impl;

import com.groupa15.entity.User;
import com.groupa15.repo.UserRepo;
import com.groupa15.service.UserService;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
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

    @Override
    public User getUserByUserId(int userId) {
        return userRepo.getById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
//        User queryUser = new User();
//        queryUser.setUsername(username);
//        Optional<User> user = userRepo.findOne(Example.of(queryUser));
//        return user.orElse(null);
        User user = userRepo.findOneByUsername(username);
        if(user == null) {
            throw new UnknownAccountException();
        }
        return user;
    }

    // TODO(Zirui): Check the account Conflicts
    @Override
    public void registerUser(String username, String password) {
        User user = new User()
                .setUsername(username)
                .setPassword(password);
        Md5Hash md5Hash = new Md5Hash(user.getPassword());
        user.setPassword(md5Hash.toHex());
        userRepo.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = getUserByUsername(username);
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("============================");
        System.out.println(user.getPassword());
        System.out.println(md5Hash.toHex());
        System.out.println("============================");
        return user.getPassword().equals(md5Hash.toHex()) ? user : null;
        //return user.getPassword().equals(password) ? user : null;
    }
}

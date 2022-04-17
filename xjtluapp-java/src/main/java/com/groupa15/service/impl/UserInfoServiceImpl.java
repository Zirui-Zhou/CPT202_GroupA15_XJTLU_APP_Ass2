package com.groupa15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.entity.UserInfo;
import com.groupa15.mapper.UserInfoMapper;
import com.groupa15.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUserId, userInfo.getUserId());
        this.update(userInfo, wrapper);
    }

}

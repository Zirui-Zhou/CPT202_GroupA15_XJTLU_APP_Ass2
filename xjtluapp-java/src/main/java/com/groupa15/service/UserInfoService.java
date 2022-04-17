package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.entity.Resource;
import com.groupa15.entity.UserInfo;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

public interface UserInfoService extends IService<UserInfo> {
    void updateUserInfo(UserInfo userInfo);
}

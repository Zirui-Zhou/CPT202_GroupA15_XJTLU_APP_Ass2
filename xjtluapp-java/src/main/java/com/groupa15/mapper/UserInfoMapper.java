package com.groupa15.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.User;
import com.groupa15.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}

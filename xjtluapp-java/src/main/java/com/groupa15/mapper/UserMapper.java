package com.groupa15.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.User;
import com.groupa15.entity.vo.UserInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Qi Xu
 * @date 2022/3/15
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    UserInfoVO selectUserInfoVoByUserId(@Param("userId") Long userId);

}

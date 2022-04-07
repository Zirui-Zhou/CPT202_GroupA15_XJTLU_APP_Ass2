package com.groupa15.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("Select * from user")
    List<User> findAll();

    @Insert("Insert into user (username, password) values (#{username}, #{password})")
    int insert(User user);

//    @Update("Update user set username=#{username}, password=#{password} where id = #{id}")
//    int update(User user);

    @Delete("Delete from user where id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Select("Select * from user where username like #{username} limit #{pageNum}, #{pageSize} ")
    List<User> findPage(Integer pageNum, Integer pageSize, String username);

}

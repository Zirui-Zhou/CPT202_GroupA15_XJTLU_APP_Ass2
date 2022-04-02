package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
//database mapper label
public interface UserMapper {

    @Select("Select * from user")
    List<User> findAll();

    @Insert("Insert into user (username, password) values (#{username}, #{password})")
    int insert(User user);

    //@Update("Update user set username=#{username}, password=#{password} where id = #{id}")
    int update(User user);

    @Delete("Delete from user where id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Select("Select * from user limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

}

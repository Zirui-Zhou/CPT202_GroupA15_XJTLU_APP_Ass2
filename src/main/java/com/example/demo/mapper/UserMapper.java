package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
//database mapper label
public interface UserMapper {

    @Select("Select * from user")
    List<User> findAll();

    @Insert("Insert into user (user_name, password) values (#{user_name}, #{password})")
    int insert(User user);

    @Update("Update user set user_name=#{user_name}, password=#{password} where id=#{id}")
    int update(User user);
}

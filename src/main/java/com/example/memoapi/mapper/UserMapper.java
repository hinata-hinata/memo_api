package com.example.memoapi.mapper;

import com.example.memoapi.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT user_id, username, password, created_at FROM users WHERE username = #{username}")
    User selectUserByUsername(String username);

    @Insert("insert into users(username, password, created_at) values (#{username}, #{password}, current_timestamp)")
    void insert(String username, String password);
}


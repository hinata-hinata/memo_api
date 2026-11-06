package com.example.memo_api.mapper;

import com.example.memo_api.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("select user_id, username, password, created_at from users where username = ${username} ")
  User selectUserByUsername(String username);
}

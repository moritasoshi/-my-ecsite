package com.example.myecsite.mapper;

import com.example.myecsite.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer save(User user);
    User findByEmail(String email);
}

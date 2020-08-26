package com.example.myecsite.service;

import com.example.myecsite.domain.User;
import com.example.myecsite.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.save(user);
    }

    public boolean isRegistered(String email){
        if(Objects.nonNull(userMapper.findByEmail(email))){
            return true;
        } else{
            return false;
        }
    }
}

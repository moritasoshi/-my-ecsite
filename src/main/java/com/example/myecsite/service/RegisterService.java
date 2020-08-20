package com.example.myecsite.service;

import com.example.myecsite.domain.User;
import com.example.myecsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class RegisterService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean isRegistered(String email){
        if(Objects.nonNull(userRepository.findByEmail(email))){
            return true;
        } else{
            return false;
        }
    }
}

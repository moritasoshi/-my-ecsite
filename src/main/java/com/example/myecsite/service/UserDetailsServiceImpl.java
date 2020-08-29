package com.example.myecsite.service;

import com.example.myecsite.domain.LoginUser;
import com.example.myecsite.domain.User;
import com.example.myecsite.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userMapper.findByEmail(email);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("そのEmailは登録されていません。");
        }

        // 権限付与
        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER")); // ユーザー権限付与
        return new LoginUser(user, authorityList);
    }
}
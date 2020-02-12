package com.carlopezg.springjwt.service.impl;

import com.carlopezg.springjwt.entity.User;
import com.carlopezg.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(""));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                new ArrayList<>()); //Authorities
    }
}

package com.carlopezg.springjwt.service.impl;

import com.carlopezg.springjwt.entity.ApplicationUser;
import com.carlopezg.springjwt.repository.ApplicationUserRepository;
import com.carlopezg.springjwt.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    ApplicationUserRepository repository;

    @Override
    public Optional<ApplicationUser> loadUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}

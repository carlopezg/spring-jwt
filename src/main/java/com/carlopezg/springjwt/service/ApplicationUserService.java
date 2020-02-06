package com.carlopezg.springjwt.service;

import com.carlopezg.springjwt.entity.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserService {

    Optional<ApplicationUser> loadUserByUsername(String username);
}

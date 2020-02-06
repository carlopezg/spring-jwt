package com.carlopezg.springjwt.security.service;

import com.carlopezg.springjwt.entity.ApplicationUser;
import com.carlopezg.springjwt.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserService applicationUserService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserService.loadUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(""));
        return new User(applicationUser.getUsername(),
                applicationUser.getPassword(),
                new ArrayList<>());     //Authorities
    }
}

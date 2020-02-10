package com.carlopezg.springjwt.security.service.impl;

import com.carlopezg.springjwt.security.JwtTokenProvider;
import com.carlopezg.springjwt.security.model.SecurityData;
import com.carlopezg.springjwt.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    public String generateAuthenticationToken(SecurityData data) {
        try {
            String username = data.getUsername();
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            UserDetails userDetails = ((UserDetails) auth.getPrincipal());
            return jwtTokenProvider.generateToken(userDetails);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}

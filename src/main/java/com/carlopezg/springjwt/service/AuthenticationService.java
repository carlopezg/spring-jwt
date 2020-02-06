package com.carlopezg.springjwt.service;

import com.carlopezg.springjwt.security.model.SecurityData;

public interface AuthenticationService {

    String generateAuthenticationToken(SecurityData security) throws Exception;
}

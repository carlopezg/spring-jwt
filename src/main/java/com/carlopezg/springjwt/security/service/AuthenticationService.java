package com.carlopezg.springjwt.security.service;

import com.carlopezg.springjwt.security.model.SecurityData;

public interface AuthenticationService {

    String generateAuthenticationToken(SecurityData security) throws Exception;
}

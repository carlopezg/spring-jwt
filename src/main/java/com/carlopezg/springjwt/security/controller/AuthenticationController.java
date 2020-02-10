package com.carlopezg.springjwt.security.controller;

import com.carlopezg.springjwt.security.model.SecurityData;
import com.carlopezg.springjwt.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    @Autowired
    AuthenticationService service;

    @PostMapping("/auth/login")
    public ResponseEntity generateAuthentication(@RequestBody SecurityData security) throws Exception {
        String token = service.generateAuthenticationToken(security);
        return ResponseEntity.ok().header("Authorization", "Bearer " + token).build();
    }
}

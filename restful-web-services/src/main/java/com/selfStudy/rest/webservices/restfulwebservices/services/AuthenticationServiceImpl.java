package com.selfStudy.rest.webservices.restfulwebservices.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Override
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("jerome");
        boolean isValidPassword = password.equalsIgnoreCase("garcia");
        return isValidUserName && isValidPassword;
    }
}

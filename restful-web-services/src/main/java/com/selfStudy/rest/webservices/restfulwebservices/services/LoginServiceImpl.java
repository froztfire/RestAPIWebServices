package com.selfStudy.rest.webservices.restfulwebservices.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Override
    public String login(String str) {
        return str;
    }
}

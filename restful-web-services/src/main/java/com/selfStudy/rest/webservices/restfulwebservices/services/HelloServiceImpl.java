package com.selfStudy.rest.webservices.restfulwebservices.services;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String str) {
        return str;
    }
}

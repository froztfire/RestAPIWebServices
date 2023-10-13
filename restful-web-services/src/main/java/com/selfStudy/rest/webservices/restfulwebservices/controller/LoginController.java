package com.selfStudy.rest.webservices.restfulwebservices.controller;

import com.selfStudy.rest.webservices.restfulwebservices.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("login1")
    public ResponseEntity<String>  loginPage(){
        return new ResponseEntity<>(loginService.login("login"), HttpStatus.OK);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage(){
        return "login";
    }
}

package com.selfStudy.rest.webservices.restfulwebservices.controller;

import com.selfStudy.rest.webservices.restfulwebservices.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    private

    @RequestMapping("/hello")
    ResponseEntity<String> hello(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First HTML page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My First HTML with Body\t");
        sb.append("</body>");
        sb.append("</html>");
        return new ResponseEntity<String>(helloService.hello(sb.toString()), HttpStatus.OK);
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}

package com.selfStudy.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Jerome Garcia");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Jerome","Garcia"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam(){
        return new PersonV1("Jerome Garcia");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam(){
        return new PersonV2(new Name("Jerome","Garcia"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Jerome Garcia");
    }

    @GetMapping(path = "/person/header" ,headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Jerome","Garcia"));
    }
    @GetMapping(value = "/person/accept",  produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonRequestHeaderAccept() {
        return new PersonV1("Jerome Garcia");
    }
    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonRequestHeaderAccept(){
        return new PersonV2(new Name("Jerome","Garcia"));
    }



}
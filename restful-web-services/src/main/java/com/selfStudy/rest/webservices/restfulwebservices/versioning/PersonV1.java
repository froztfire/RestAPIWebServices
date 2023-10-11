package com.selfStudy.rest.webservices.restfulwebservices.versioning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersonV1 {

    private String name;
    public PersonV1(String name) {
        super();
        this.name = name;
    }
}

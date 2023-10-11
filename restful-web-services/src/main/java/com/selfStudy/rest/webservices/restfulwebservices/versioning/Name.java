package com.selfStudy.rest.webservices.restfulwebservices.versioning;

import lombok.Data;

@Data
public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;

    }
}

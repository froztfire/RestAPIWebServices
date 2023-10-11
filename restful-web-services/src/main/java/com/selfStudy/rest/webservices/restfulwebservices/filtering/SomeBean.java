package com.selfStudy.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties({"field1", "field2"})
public class SomeBean {
    private String field1;
//    @JsonIgnore
    private String field2;
    private String field3;
}

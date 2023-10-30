package com.selfStudy.rest.webservices.restfulwebservices.services;

import com.selfStudy.rest.webservices.restfulwebservices.model.ToDo;

import java.util.List;

public interface TodoService {

    List<ToDo> findByUserName(String username);

}

package com.selfStudy.rest.webservices.restfulwebservices.controller;

import com.selfStudy.rest.webservices.restfulwebservices.model.ToDo;
import com.selfStudy.rest.webservices.restfulwebservices.services.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {
    @Autowired
    private ToDoServiceImpl toDoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap){
        List<ToDo> todos = toDoService.findByUserName("in28minutes");
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewToDoPage(){
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewToDoPage(){
        return "redirect:list-todos";
    }
}

package com.selfStudy.rest.webservices.restfulwebservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDo {
    private int id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean done;
}

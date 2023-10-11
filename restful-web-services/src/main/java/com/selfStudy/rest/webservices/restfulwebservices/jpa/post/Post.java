package com.selfStudy.rest.webservices.restfulwebservices.jpa.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.selfStudy.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}

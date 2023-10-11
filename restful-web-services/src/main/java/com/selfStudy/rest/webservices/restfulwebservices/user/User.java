package com.selfStudy.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.selfStudy.rest.webservices.restfulwebservices.jpa.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should at least 2 characters")
   // @JsonProperty("user_name")
    private String name;
   // @JsonProperty("birth_date")
    @Past(message = "Birthdate should past date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}

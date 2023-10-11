package com.selfStudy.rest.webservices.restfulwebservices.jpa;

import com.selfStudy.rest.webservices.restfulwebservices.jpa.post.Post;
import com.selfStudy.rest.webservices.restfulwebservices.jpa.repository.PostRepository;
import com.selfStudy.rest.webservices.restfulwebservices.jpa.repository.UserRepository;
import com.selfStudy.rest.webservices.restfulwebservices.user.User;
import com.selfStudy.rest.webservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/jpa/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @GetMapping(path = "/jpa/posts")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<Optional<User>> getUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(Long.valueOf(id));

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        EntityModel<Optional<User>> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUser());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(Long.valueOf(id));
    }

    @GetMapping(path = "/jpa/user/{id}/post")
    public List<Post> retrievePostsForUser(@PathVariable Integer id) {
      Optional<User> user = userRepository.findById(Long.valueOf(id));
        if (user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
       return user.get().getPosts();
    }

    @PostMapping(path = "/jpa/user/{id}/post")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(Long.valueOf(id));
        if (user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

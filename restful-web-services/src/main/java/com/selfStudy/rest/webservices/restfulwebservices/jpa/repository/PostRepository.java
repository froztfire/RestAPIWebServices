package com.selfStudy.rest.webservices.restfulwebservices.jpa.repository;

import com.selfStudy.rest.webservices.restfulwebservices.jpa.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

package com.selfStudy.rest.webservices.restfulwebservices.jpa.repository;

import com.selfStudy.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

package com.selfStudy.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

//[    static {
//        users.add(new User(++userCount, "Migo", LocalDate.now().minusYears(3)));
//        users.add(new User(++userCount, "Jeidy", LocalDate.now().minusYears(11)));
//        users.add(new User(++userCount, "Sancho", LocalDate.now().minusYears(8)));
//        users.add(new User(++userCount, "Shantal", LocalDate.now().minusYears(12)));
//    }


    public List<User> findAll(){
        return users;
    }

    public User findOne(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);

    }
}

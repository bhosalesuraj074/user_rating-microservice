package com.user.service;


import com.user.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    //get all the users
    List<User> loadAllUsers();

    // get user by id
    User loadUserById(@PathVariable String id);

    // create the new user
    User createUser(@RequestBody User user);


}

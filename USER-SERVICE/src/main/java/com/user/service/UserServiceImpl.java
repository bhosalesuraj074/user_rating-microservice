package com.user.service;

import com.user.entities.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> loadAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User loadUserById(String id) {
      return  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found having id"+ id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}

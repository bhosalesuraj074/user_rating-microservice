package com.user.service;

import com.user.entities.Hotel;
import com.user.entities.Rating;
import com.user.entities.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.external.HotelService;
import com.user.external.RatingService;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private HotelService hotelService;

    @Override
    public List<User> loadAllUsers() {
        List<User> users = userRepository.findAll();
        List<User> userStream = users.stream()
                .map(user -> {

                    user.setRatings(ratingService.loadRatingByUserId(user.getUserId()).getBody());
                    return user;

                }).collect(Collectors.toList());
        return  userStream;
    }

    @Override
    public User loadUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found having id" + id));
        List<Rating> ratingList = ratingService.loadRatingByUserId(user.getUserId()).getBody();
        List<Rating> hotelList = ratingList
                .stream()
                .map((rating -> {
                    rating.setHotel(hotelService.loadHotelById(rating.getHotelId()).getBody());
                    return  rating;
                })).collect(Collectors.toList());
        user.setRatings(hotelList);
        return user;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}

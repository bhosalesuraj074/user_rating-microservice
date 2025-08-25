package com.rating.controller;

import com.rating.entities.Rating;
import com.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //
    @GetMapping
    public ResponseEntity<List<Rating>> loadAllRatings() {
        List<Rating> ratings = ratingService.getRatings();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> loadRatingByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> loadRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

    }


}

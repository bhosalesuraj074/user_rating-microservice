package com.user.external;


import com.user.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> loadAllRatings();

    @GetMapping("/ratings/users/{userId}")
    public ResponseEntity<List<Rating>> loadRatingByUserId(@PathVariable String userId);

    @GetMapping("/ratings/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> loadRatingByHotelId(@PathVariable String hotelId);

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating);
}

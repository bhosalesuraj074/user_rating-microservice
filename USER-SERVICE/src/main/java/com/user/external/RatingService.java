package com.user.external;

import com.user.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}

package com.user.external;

import com.user.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    // get all the hotels
    @GetMapping("/hotels")
    ResponseEntity<List<Hotel>> loadAllHotel();

    //getHotel by Id
    @GetMapping("/hotels/{hotelId}")
    ResponseEntity<Hotel> loadHotelById(@PathVariable String hotelId);

    //create new hotel
    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel);
}

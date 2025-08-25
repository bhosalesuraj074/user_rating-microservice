package com.hotel.controller;

import com.hotel.entities.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
@Autowired
private HotelService hotelService;

    //get All hotel
    @GetMapping
    public ResponseEntity<List<Hotel>> loadAllHotel(){
        List<Hotel> hotels = hotelService.getAll();
        if (hotels.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(hotels);
    }

    //get hotel by id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> loadHotelById(@PathVariable String hotelId){
        return  ResponseEntity.ok(hotelService.get(hotelId));
    }

    //create hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }


}

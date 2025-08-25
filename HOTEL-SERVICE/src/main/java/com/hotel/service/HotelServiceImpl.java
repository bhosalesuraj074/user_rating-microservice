package com.hotel.service;

import com.hotel.entities.Hotel;
import com.hotel.exceptions.HotelNotFoundException;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return  hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return  hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel not found having id: "+id));
    }

}

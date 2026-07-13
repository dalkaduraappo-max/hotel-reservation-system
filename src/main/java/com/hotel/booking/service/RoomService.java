package com.hotel.booking.service;

import com.hotel.booking.domain.Room;
import com.hotel.booking.exception.ResourceNotFoundException;
import com.hotel.booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomService {

    private final RoomRepository roomRepository;


    @Transactional(readOnly = true) // Indicates that this method should be run within a read-only transaction
    public List<Room> getAllRooms() { // Method signature to get all rooms
        return roomRepository.findAll(); // Returns all records from the room repository
    }


    @Transactional(readOnly = true)
    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id - " + id));
    }


}
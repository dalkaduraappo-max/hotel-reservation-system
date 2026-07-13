package com.hotel.booking.controller;

import com.hotel.booking.domain.Room;
import com.hotel.booking.dto.response.RoomResponse;
import com.hotel.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {

        List<RoomResponse> rooms = roomService.getAllRooms()
                .stream().map(room -> RoomResponse.from(room)).toList();

        return ResponseEntity.ok(rooms);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(RoomResponse.from(roomService.getById(id)));
    }
}





package com.hotel.booking.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="rooms")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_number",nullable = false,unique = true,length = 10)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private RoomType type;

    @Column(name = "price_per_night",nullable = false,precision = 10,scale = 2)
    private BigDecimal pricePerNight;

    @Column(nullable = false)
    private Integer capacity;

    @Column(columnDefinition = "Text")
    private String description;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private  RoomStatus status = RoomStatus.AVAILABLE;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createAt;

}

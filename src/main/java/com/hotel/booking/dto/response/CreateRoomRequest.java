package com.hotel.booking.dto.response;

import com.hotel.booking.domain.RoomType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateRoomRequest {

    @NotBlank(message = "Room number is required")
    @Size(max = 10, message = "Room number cannot exceed 10 characters")
    private String roomNumber;

    @NotNull(message = "Room type is required")
    private RoomType type;

    @NotNull(message = "Price per night is required")
    @DecimalMin(value = "1.00", message = "Price per night must be at least 1.00")
    @Digits(integer = 8, fraction = 2, message = "Invalid price format") // 1234567890.231 - invalid
    private BigDecimal pricePerNight;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 5, message = "Capacity cannot exceed 5")
    private Integer capacity;

}
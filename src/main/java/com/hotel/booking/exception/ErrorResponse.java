package com.hotel.booking.exception;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ErrorResponse {
    private final int status;
    private final  String error;
    private final String message;
    private final LocalDateTime timeStamp = LocalDateTime.now();

    public ErrorResponse(int status,String error , String message){
        this.status = status;
        this.error = error;
        this.message = message;
    }
}

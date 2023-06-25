package com.example.JwtAuthentication.Exception;

public class AvailabilityException extends RuntimeException{
    public AvailabilityException(String message){
        super(message);
    }
}
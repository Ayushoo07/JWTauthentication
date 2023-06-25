package com.example.JwtAuthentication.Exception;

public class NotAvailabilityException extends RuntimeException{
    public NotAvailabilityException(String message){
        super(message);
    }
}
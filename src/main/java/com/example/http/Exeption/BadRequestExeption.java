package com.example.http.Exeption;

public class BadRequestExeption extends RuntimeException {
    public BadRequestExeption(String message) {
        super(message);
    }
}

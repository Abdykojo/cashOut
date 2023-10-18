package com.example.http.Exeption;

public class AuthenticationExeption extends RuntimeException{
    public AuthenticationExeption(String message) {
        super(message);
    }
}

package com.example.http.service;

import com.example.http.Exeption.AuthenticationExeption;
import com.example.http.request.RegisterRequest;
import com.example.http.response.AuthenticationResponse;
import org.springframework.cache.annotation.Cacheable;

public interface AuthService {

    String authentication () throws AuthenticationExeption;

    AuthenticationResponse registration (RegisterRequest request) throws AuthenticationExeption;
}

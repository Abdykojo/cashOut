package com.example.http.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ConnectionService<T> {
    private final AuthService authService;


    private final RestTemplate restTemplate;

    public T getConnection(T t, String url, Class<T> tClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setBearerAuth(authService.authentication());

        HttpEntity<T> httpEntity = new HttpEntity<>(t, headers);
        return restTemplate.postForEntity(url, httpEntity, tClass).getBody(); //TRY CATCH

    }



}

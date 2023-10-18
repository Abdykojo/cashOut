package com.example.http.service.impl;

import com.example.http.Exeption.AuthenticationExeption;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.request.AuthenticationRequest;
import com.example.http.request.RegisterRequest;
import com.example.http.response.AuthenticationResponse;
import com.example.http.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RestTemplate restTemplate;

    @Override
    @Cacheable(value = "token")
    public String authentication() throws AuthenticationExeption {

        try {
            AuthenticationRequest request = new AuthenticationRequest();
            request.setEmail("ooo@gmail.com");
            request.setPassword("100");
            log.info("AuthServiceImpl -> " + request);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            HttpEntity<AuthenticationRequest> httpEntity = new HttpEntity<>(request, headers);
            return Objects.requireNonNull(restTemplate.postForEntity(RestUrl.AUTHENTICATION.getUrl(), httpEntity,
                    AuthenticationResponse.class).getBody()).getToken();

        } catch (AuthenticationExeption e) {

            throw new AuthenticationExeption(RespMessage.NOT_AUTH.getMessage());
        }
    }

    @Override
    @Cacheable(value = "token")
    public AuthenticationResponse registration(RegisterRequest request) throws AuthenticationExeption {
           log.info("AuthServiceImpl -> " + request);
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            HttpEntity<RegisterRequest> httpEntity = new HttpEntity<>(request, headers);
             return restTemplate.postForEntity
                     (RestUrl.REGISTRATION.getUrl(), httpEntity, AuthenticationResponse.class).getBody();

//             return token;

        } catch (AuthenticationExeption e) {

            throw new AuthenticationExeption(RespMessage.NOT_AUTH.getMessage());
        }
    }
}

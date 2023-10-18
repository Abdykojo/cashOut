package com.example.http.service.impl;

import com.example.http.Exeption.AuthenticationExeption;
import com.example.http.Exeption.CashExeption;
import com.example.http.Exeption.UserNotFoundExeption;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.repository.UserRepository;
import com.example.http.request.CheckRequest;
import com.example.http.response.BaseResponse;
import com.example.http.response.CheckRespint;
import com.example.http.service.CheckService;
import com.example.http.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final UserRepository userRepository;
    private final ConnectionService<CheckRequest> connectionService;

    @Override
    public BaseResponse checkPayment(CheckRequest checkRequest) throws CashExeption {

        log.info("CheckServiceImpls -> {}", checkRequest);

        userRepository.findByPhoneNumber(checkRequest.getSender()).orElseThrow(() ->
                new UserNotFoundExeption(RespMessage.USER_NOT_FOUND.getMessage()));

        try {

            CheckRequest response = connectionService.getConnection(checkRequest, RestUrl.CHECK.getUrl(),
                    CheckRequest.class);

            CheckRespint checkRespint = CheckRespint.builder()
                    .account(checkRequest.getAccount())
                    .currency(checkRequest.getCurrency())
                    .name(response.getName())
                    .build();

            return BaseResponse.builder()
                    .code(response.getCode())
                    .message(response.getMessage())
                    .checkRespint(checkRespint)
                    .qid(response.getQid())
                    .dts(String.valueOf(LocalDateTime.now()))
                    .build();

        } catch (HttpStatusCodeException e) {

            log.error("CheckServiceImpl -> {}", e.getLocalizedMessage());

            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {

                throw new UserNotFoundExeption(RespMessage.USER_NOT_FOUND.getMessage());
            }
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {

                throw new AuthenticationExeption(RespMessage.NOT_AUTH.getMessage());
            }
            throw new UserNotFoundExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());
        }
    }
}



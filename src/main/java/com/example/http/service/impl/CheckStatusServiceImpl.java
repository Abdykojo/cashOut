package com.example.http.service.impl;

import com.example.http.Exeption.CashExeption;
import com.example.http.Exeption.UserNotFoundExeption;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.request.CheckStatusRequest;
import com.example.http.response.BaseResponse;
import com.example.http.service.CheckStatusService;
import com.example.http.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor

public class CheckStatusServiceImpl implements CheckStatusService {

    private final ConnectionService<CheckStatusRequest> connectionService;

    @Override
    public BaseResponse checkStatus(CheckStatusRequest request) throws CashExeption {

        log.info("CheckStatusServiceImpls -> {}", request);

        try {

            CheckStatusRequest response = connectionService.getConnection(request, RestUrl.STATUS.getUrl(), CheckStatusRequest.class);

            return BaseResponse.builder()
                    .code(response.getCode())
                    .message(response.getMessage())
                    .dts(String.valueOf(LocalDateTime.now()))
                    .qid(response.getQid())
                    .build();

        } catch (HttpStatusCodeException e) {

            log.error("CheckStatusServiceImpls -> {}", e.getLocalizedMessage());

            throw new UserNotFoundExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());
        }
    }
}



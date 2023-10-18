package com.example.http.service.impl;

import com.example.http.Exeption.BalanceExeption;
import com.example.http.Exeption.CashExeption;
import com.example.http.Exeption.CreditExeption;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.request.ScheduleRequest;
import com.example.http.response.BaseResponse;
import com.example.http.service.ChartService;
import com.example.http.service.ConnectionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService {
    private final ConnectionService<ScheduleRequest> connectionService;

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public BaseResponse calculate(ScheduleRequest request) throws CashExeption {

        log.info("ChartServiceImpl -> {}", request);

        try {

            ScheduleRequest response = connectionService.getConnection(request, RestUrl.CALCULATE.getUrl(), ScheduleRequest.class);


            return BaseResponse.builder()
                    .code(response.getCode())
                    .message(response.getMessage())
                    .build();

        } catch (

                HttpStatusCodeException e) {

            log.error("ChartServiceImpl -> {}", e.getLocalizedMessage());

            if (e.getStatusCode().equals(HttpStatus.PAYMENT_REQUIRED)) {

                throw new BalanceExeption(RespMessage.NOT_MONEY.getMessage());
            }
            if (e.getStatusCode().equals(HttpStatus.PAYLOAD_TOO_LARGE)) {

                throw new CreditExeption(RespMessage.LARGE_SUM.getMessage());
            }
            throw new CashExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());

        }
    }
}


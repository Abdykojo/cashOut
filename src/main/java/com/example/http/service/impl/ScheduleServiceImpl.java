package com.example.http.service.impl;

import com.example.http.Exeption.*;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.request.ScheduleRequest;
import com.example.http.response.ScheduleResponse;
import com.example.http.service.ConnectionService;
import com.example.http.service.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ConnectionService<ScheduleRequest> connectionService;

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public ScheduleResponse creditPayment(ScheduleRequest request) throws CashExeption {

        log.info("ScheduleServiceImpl -> {}", request);

        try {

            ScheduleRequest response = connectionService.getConnection(request, RestUrl.PAY_CREDIT.getUrl(), ScheduleRequest.class);


            return ScheduleResponse.builder()
                    .payment(response.getPayment())
                    .balance(response.getBalance())
                    .status(response.getStatus())
                    .build();

        } catch (

                HttpStatusCodeException e) {

            log.error("PayServiceImpls -> {}", e.getLocalizedMessage());

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

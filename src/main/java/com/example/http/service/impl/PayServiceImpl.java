package com.example.http.service.impl;

import com.example.http.Exeption.*;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.entity.Cards;
import com.example.http.entity.Check;
import com.example.http.entity.Course;
import com.example.http.entity.User;
import com.example.http.repository.*;
import com.example.http.request.PayRequest;
import com.example.http.response.BaseResponse;
import com.example.http.service.ConnectionService;
import com.example.http.service.PayService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final ConnectionService<PayRequest> connectionService;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public BaseResponse pay(PayRequest request) throws CashExeption {

        log.info("PayServiceImpls -> {}", request);

        try {

            PayRequest response = connectionService.getConnection(request, RestUrl.PAY.getUrl(), PayRequest.class);

            return BaseResponse.builder()

                    .code(response.getCode())
                    .message(response.getMessage())
                    .dts(String.valueOf(LocalDateTime.now()))
                    .qid(response.getQid())
                    .build();

        } catch (HttpStatusCodeException e) {

            log.error("PayServiceImpls -> {}", e.getLocalizedMessage());

            if (e.getStatusCode().equals(HttpStatus.IM_USED)) {
                throw new QuidExeption(RespMessage.QID_IS_PRESENT.getMessage());
            }
            if (e.getStatusCode().equals(HttpStatus.BAD_GATEWAY)) {
                throw new BadRequestExeption(RespMessage.BAD_REQUEST.getMessage());
            }
            if (e.getStatusCode().equals(HttpStatus.PAYMENT_REQUIRED)) {
                throw new BalanceExeption(RespMessage.NOT_MONEY.getMessage());
            }
            throw new CashExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());

        }

    }

}

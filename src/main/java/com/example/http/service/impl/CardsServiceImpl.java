package com.example.http.service.impl;

import com.example.http.Exeption.BalanceExeption;
import com.example.http.Exeption.CashExeption;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.request.CardsRequest;
import com.example.http.response.BaseResponse;
import com.example.http.service.CardsService;
import com.example.http.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {
    private final ConnectionService<CardsRequest> connectionService;

    @Override
    public BaseResponse createCard(CardsRequest request) throws CashExeption {

        try {

            CardsRequest response = connectionService.getConnection(request, RestUrl.GET_CARDS.getUrl(), CardsRequest.class);

            return BaseResponse.builder()
                    .code(response.getCode())
                    .message(response.getMessage())
                    .build();

        } catch (

                HttpStatusCodeException e) {

            log.error("ChartServiceImpl -> {}", e.getLocalizedMessage());

           throw new CashExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());

        }

    }
}

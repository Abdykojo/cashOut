package com.example.http.service.impl;

import com.example.http.Exeption.CashExeption;
import com.example.http.Exeption.UserNotFoundExeption;
import com.example.http.commons.CreditStatus;
import com.example.http.commons.RespMessage;
import com.example.http.commons.RestUrl;
import com.example.http.request.CreditRequest;
import com.example.http.response.CreditResponse;
import com.example.http.service.AuthService;
import com.example.http.service.ConnectionService;
import com.example.http.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {
    private final ConnectionService<CreditRequest> connectionService;
    private final AuthService authService;
    private final RestTemplate restTemplate;

    @Override
    public CreditResponse getCredit(CreditRequest request) throws CashExeption {

        log.info("CreditServiceImpls -> {}", request);

        try {

            CreditRequest response = connectionService.getConnection(request, RestUrl.GET_CREDIT.getUrl(), CreditRequest.class);

            return CreditResponse.builder()
                    .id(response.getId())
                    .payment(response.getPayment())
                    .percent(response.getPercent())
                    .code(response.getMessage())
                    .status(CreditStatus.COMMITTED)
                    .sum(response.getSum())
                    .build();

        } catch (HttpStatusCodeException e) {

            log.error("CreditServiceImpls -> {}", e.getLocalizedMessage());

            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new UserNotFoundExeption(RespMessage.USER_NOT_FOUND.getMessage());
            }

            throw new CashExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());
        }
    }

    @Override
    public List<CreditResponse> findAll(CreditRequest request) throws CashExeption {

        log.info("CreditServiceImpls -> {}", request);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            headers.setBearerAuth(authService.authentication());
            HttpEntity<CreditRequest> httpEntity = new HttpEntity<>(request, headers);
            List<CreditResponse> response = restTemplate.postForEntity(RestUrl.FIND_ALL.getUrl(), httpEntity, List.class).getBody();

            return response;

        } catch (HttpStatusCodeException e) {

            log.error("CreditServiceImpls -> {}", e.getLocalizedMessage());
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new UserNotFoundExeption(RespMessage.USER_NOT_FOUND.getMessage());
            }

            throw new CashExeption(RespMessage.SERVICE_NOT_RABOTAT.getMessage());
        }
    }
}

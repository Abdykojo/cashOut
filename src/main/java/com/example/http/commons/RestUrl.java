package com.example.http.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RestUrl {

    CHECK("http://localhost:8082/api/v1/check"),

    PAY("http://localhost:8082/api/v1/pay"),

    STATUS("http://localhost:8082/api/v1/status"),

    AUTHENTICATION("http://localhost:8082/api/v1/auth/authenticate"),
    REGISTRATION("http://localhost:8082/api/v1/auth/register"),
    GET_CREDIT("http://localhost:8082/api/v1/credit/get"),
    FIND_ALL("http://localhost:8082/api/v1/credit/findAll"),
    PAY_CREDIT("http://localhost:8082/api/v1/credit/payCredit"),
    GET_CARDS("http://localhost:8082/api/v1/cards"),
    CALCULATE("http://localhost:8082/api/v1/credit/calculate");


    private String url;
}

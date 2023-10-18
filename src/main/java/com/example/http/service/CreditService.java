package com.example.http.service;

import com.example.http.Exeption.CashExeption;
import com.example.http.request.CreditRequest;
import com.example.http.request.ScheduleRequest;
import com.example.http.response.BaseResponse;
import com.example.http.response.CreditResponse;

import java.util.List;

public interface CreditService {


    CreditResponse getCredit(CreditRequest request) throws CashExeption;

    List<CreditResponse> findAll(CreditRequest request) throws CashExeption;
}

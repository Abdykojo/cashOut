package com.example.http.service;

import com.example.http.Exeption.CashExeption;
import com.example.http.request.CreditRequest;
import com.example.http.request.ScheduleRequest;
import com.example.http.response.BaseResponse;
import jakarta.transaction.Transactional;

public interface ChartService {
    @Transactional(Transactional.TxType.REQUIRED)
    BaseResponse calculate(ScheduleRequest request) throws CashExeption;
}

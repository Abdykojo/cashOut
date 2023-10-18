package com.example.http.service;

import com.example.http.Exeption.CashExeption;
import com.example.http.request.ScheduleRequest;
import com.example.http.response.ScheduleResponse;
import jakarta.transaction.Transactional;

public interface ScheduleService {
    @Transactional(Transactional.TxType.REQUIRED)
    ScheduleResponse creditPayment(ScheduleRequest request) throws CashExeption;
}

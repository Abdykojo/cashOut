package com.example.http.service;
import com.example.http.Exeption.CashExeption;
import com.example.http.request.AuthenticationRequest;
import com.example.http.request.CheckRequest;
import com.example.http.response.BaseResponse;


public interface CheckService {

    BaseResponse checkPayment(CheckRequest request) throws CashExeption;

}

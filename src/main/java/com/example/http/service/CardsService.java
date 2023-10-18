package com.example.http.service;

import com.example.http.request.CardsRequest;
import com.example.http.response.BaseResponse;

public interface CardsService {
    BaseResponse createCard (CardsRequest request);
}

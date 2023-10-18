package com.example.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsResponse {

    private String account;
    private Double balance;
    private int number;

    private String currency;

    private boolean main;
    private LocalDateTime date;


}

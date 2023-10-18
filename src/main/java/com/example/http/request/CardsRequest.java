package com.example.http.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardsRequest {
    @NonNull
    @XmlElement
    private String account;
    @XmlElement
    private Double balance;
    @XmlElement
    private int number;
    @NonNull
    @XmlElement
    private String currency;
    @NonNull
    @XmlElement
    private boolean main;
    @XmlElement
    private LocalDateTime date;
    private String code;
    private String message;


}

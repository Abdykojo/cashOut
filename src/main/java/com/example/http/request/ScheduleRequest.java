package com.example.http.request;

import com.example.http.commons.CreditStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class ScheduleRequest {

    @NonNull
    @XmlElement
    private Long creditId;
    @NonNull
    @XmlElement
    private double payment;
    @NonNull
    @XmlElement
    private String currency;
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @XmlElement
    private LocalDateTime date;
    @XmlElement
    private double balance;
    @XmlElement
    private CreditStatus status;
    @XmlElement
    private String code;
    @XmlElement
    private String message;


}

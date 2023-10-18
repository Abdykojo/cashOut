package com.example.http.request;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class CheckRequest {

    @NonNull
    @XmlElement
    private String currency;
    @NonNull
    @XmlElement
    private String account;
    @NonNull
    @XmlElement
    private String sender;
    @XmlElement
    private String status;
    @XmlElement
    private UUID qid;
    @XmlElement
    private String date;
    @XmlElement
    private String code;
    @XmlElement
    private String message;
    @XmlElement
    private  String name;
    @XmlElement
    private String type;


}

package com.example.http.request;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CheckStatusRequest {
    @XmlElement
    @NonNull
    private UUID qid;
    @XmlElement
    @NonNull
    private String date;
    @XmlElement
    private String status;
    @XmlElement
    private String code;
    @XmlElement
    private String message;
}

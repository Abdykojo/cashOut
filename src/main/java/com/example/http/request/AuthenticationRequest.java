package com.example.http.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class AuthenticationRequest {
    @NonNull
    @XmlElement
    private String email;
    @XmlElement
    @NonNull
    private String password;
}

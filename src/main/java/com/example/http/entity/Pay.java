package com.example.http.entity;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tb_pay")
public class Pay {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sum")
    private Integer sum;
    @Column(name = "currency")
    private String currency;
    @Column(name = "qid")
    private UUID qid;
    @Column(name = "account")
    private String account;
    @Column(name = "date")
    private String date;
    @Column(name = "status")
    private String status;
    @Column(name = "type")
    private String type;
}

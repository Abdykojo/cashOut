package com.example.http.entity;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import java.util.UUID;
@Data
@Entity
@Table(name = "tb_check")
public class Check {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "qid")
    private UUID qid;
    @Column (name = "account")
    private String account;
    @Column (name = "sender")
    private String sender;
    @Column(name = "date")
    private String date;
    @Column(name = "status")
    private String status;
    @Column(name = "type")
    private String type;

}

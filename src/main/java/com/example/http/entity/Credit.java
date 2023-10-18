package com.example.http.entity;
import com.example.http.commons.CreditStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tb_credits")
public class Credit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id_id")
    private User userId;
    @Column(name = "sum")
    private int sum;
    @Column(name = "percent")
    private double percent;
    @Column(name = "term")
    private double term;
    @Column(name = "payment")
    private double payment;
    @Column(name = "balance")
    private double balance;
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDateTime date;
    @Column(name = "creditStatus")
    private CreditStatus status;



    @PrePersist
    public void dateNow() {
        this.date = LocalDateTime.now();
    }



}

package com.example.http.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tb_chart")
public class Chart {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "creditId_id")
    private Credit creditId;
    @Column(name = "firstBalance")
    private double firstBalance;
    @Column(name = "payment")
    private double payment;
    @Column(name = "finalBalance")
    private double finalBalance;
    @Column(name = "currency")
    private String currency;
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDateTime date;

}

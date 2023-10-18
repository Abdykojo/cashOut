package com.example.http.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDateTime date;
    @Column(name = "email")
    private String email;


    @PrePersist
    public void dateNow() {
        this.date = LocalDateTime.now();
    }

}

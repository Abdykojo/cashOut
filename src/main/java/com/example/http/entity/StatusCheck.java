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
@Table(name = "tb_statusCheck")
public class StatusCheck {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "qid")
    private UUID qid;
    @Column(name = "dts")
    private String date;
    @Column(name = "status")
    private String status;

}

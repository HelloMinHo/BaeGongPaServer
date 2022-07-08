package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "mem_login_log")
@DynamicInsert
@Data
public class MemLoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_no", nullable = false)
    private Long autoNo;

    @Column(name = "mem_no", nullable = false)
    private Long memNo;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;


}

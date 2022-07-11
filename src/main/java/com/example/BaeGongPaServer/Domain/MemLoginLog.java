package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mem_login_log")
@DynamicInsert
@Data
public class MemLoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_no")
    private Long autoNo;

    @Column(name = "mem_no")
    private Long memNo;

    @Column(name = "ins_date")
    private LocalDateTime insDate;


}

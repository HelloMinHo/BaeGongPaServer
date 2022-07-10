package com.example.BaeGongPaServer.Domain;

import com.example.BaeGongPaServer.DomainId.RoomMemInfoId;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "room_mem_info")
@DynamicInsert
@DynamicUpdate
@Data
@IdClass(RoomMemInfoId.class)
public class RoomMemInfo {

    @Id
    @Column(name = "room_no")
    private Long roomNo;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mem_no")
    private MemInfo memNo;


    @Column(name = "order_cnt")
    private Integer orderCnt;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;



}


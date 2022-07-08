package com.example.BaeGongPaServer.Domain;

import com.example.BaeGongPaServer.DomainId.RoomMemInfoId;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "room_mem_info")
@DynamicInsert
@DynamicUpdate
@Data
@IdClass(RoomMemInfoId.class)
public class RoomMemInfo {

    @Id
    @Column(name = "room_no", nullable = false)
    private Long roomNo;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mem_no", nullable = false)
    private MemInfo memNo;


    @Column(name = "order_cnt", nullable = false)
    private Integer orderCnt;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;


}


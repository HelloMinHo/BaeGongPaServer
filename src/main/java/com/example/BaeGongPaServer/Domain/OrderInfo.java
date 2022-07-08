package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "order_info")
@DynamicInsert
@DynamicUpdate
@Data
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no", nullable = false)
    private Long id;

    @Column(name = "order_name", nullable = false, length = 50)
    private String orderName;

    @Column(name = "order_sub", nullable = false, length = 50)
    private String orderSub;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_no", nullable = false)
    private RoomInfo roomNo;

    @Column(name = "order_mem_no", nullable = false)
    private Integer orderMemNo;

    @Column(name = "order_able_date", nullable = false)
    private Instant orderAbleDate;

    @Column(name = "order_rcv_date", nullable = false)
    private Instant orderRcvDate;

    @Lob
    @Column(name = "pre_pay_yn", nullable = false)
    private String prePayYn;

    @Lob
    @Column(name = "menu_box_yn", nullable = false)
    private String menuBoxYn;

    @Column(name = "menu_box_no", nullable = false)
    private Long menuBoxNo;

    @Lob
    @Column(name = "order_end_yn", nullable = false)
    private String orderEndYn;

    @Column(name = "order_end_date", nullable = false)
    private Instant orderEndDate;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;


}
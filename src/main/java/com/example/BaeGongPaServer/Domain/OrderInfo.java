package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_info")
@DynamicInsert
@DynamicUpdate
@Data
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    private Long id;

    @Column(name = "order_name", length = 50)
    private String orderName;

    @Column(name = "order_sub", length = 50)
    private String orderSub;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_no")
    private RoomInfo roomNo;

    @Column(name = "order_mem_no")
    private Integer orderMemNo;

    @Column(name = "order_able_date")
    private LocalDateTime orderAbleDate;

    @Column(name = "order_rcv_date")
    private LocalDateTime orderRcvDate;

    @Lob
    @Column(name = "pre_pay_yn")
    private String prePayYn;

    @Lob
    @Column(name = "menu_box_yn")
    private String menuBoxYn;

    @Column(name = "menu_box_no")
    private Long menuBoxNo;

    @Lob
    @Column(name = "order_end_yn")
    private String orderEndYn;

    @Column(name = "order_end_date")
    private LocalDateTime orderEndDate;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;


}
package com.example.BaeGongPaServer.Domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "order_info")
@DynamicInsert
@DynamicUpdate
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderSub() {
        return orderSub;
    }

    public void setOrderSub(String orderSub) {
        this.orderSub = orderSub;
    }

    public RoomInfo getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(RoomInfo roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getOrderMemNo() {
        return orderMemNo;
    }

    public void setOrderMemNo(Integer orderMemNo) {
        this.orderMemNo = orderMemNo;
    }

    public Instant getOrderAbleDate() {
        return orderAbleDate;
    }

    public void setOrderAbleDate(Instant orderAbleDate) {
        this.orderAbleDate = orderAbleDate;
    }

    public Instant getOrderRcvDate() {
        return orderRcvDate;
    }

    public void setOrderRcvDate(Instant orderRcvDate) {
        this.orderRcvDate = orderRcvDate;
    }

    public String getPrePayYn() {
        return prePayYn;
    }

    public void setPrePayYn(String prePayYn) {
        this.prePayYn = prePayYn;
    }

    public String getMenuBoxYn() {
        return menuBoxYn;
    }

    public void setMenuBoxYn(String menuBoxYn) {
        this.menuBoxYn = menuBoxYn;
    }

    public Long getMenuBoxNo() {
        return menuBoxNo;
    }

    public void setMenuBoxNo(Long menuBoxNo) {
        this.menuBoxNo = menuBoxNo;
    }

    public String getOrderEndYn() {
        return orderEndYn;
    }

    public void setOrderEndYn(String orderEndYn) {
        this.orderEndYn = orderEndYn;
    }

    public Instant getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Instant orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

}
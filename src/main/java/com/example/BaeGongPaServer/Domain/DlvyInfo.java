package com.example.BaeGongPaServer.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "dlvy_info")
public class DlvyInfo {
    @Id
    @Column(name = "dlvy_no", nullable = false)
    private Integer id;

    @Column(name = "dlvy_addr", nullable = false)
    private String dlvyAddr;

    @Column(name = "dlvy_conts", nullable = false)
    private String dlvyConts;

    @Column(name = "dlvy_en_time", nullable = false)
    private Instant dlvyEnTime;

    @Column(name = "dlvy_end_slct", nullable = false)
    private Character dlvyEndSlct;

    @Column(name = "dlvy_st_time", nullable = false)
    private Instant dlvyStTime;

    @Column(name = "dlvy_title", nullable = false)
    private String dlvyTitle;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "mem_no", nullable = false)
    private Integer memNo;

    @Column(name = "menu_box_no", nullable = false)
    private Integer menuBoxNo;

    @Column(name = "menu_yn", nullable = false)
    private Character menuYn;

    @Column(name = "pay_slct", nullable = false)
    private Character paySlct;

    @Column(name = "room_no", nullable = false)
    private Integer roomNo;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDlvyAddr() {
        return dlvyAddr;
    }

    public void setDlvyAddr(String dlvyAddr) {
        this.dlvyAddr = dlvyAddr;
    }

    public String getDlvyConts() {
        return dlvyConts;
    }

    public void setDlvyConts(String dlvyConts) {
        this.dlvyConts = dlvyConts;
    }

    public Instant getDlvyEnTime() {
        return dlvyEnTime;
    }

    public void setDlvyEnTime(Instant dlvyEnTime) {
        this.dlvyEnTime = dlvyEnTime;
    }

    public Character getDlvyEndSlct() {
        return dlvyEndSlct;
    }

    public void setDlvyEndSlct(Character dlvyEndSlct) {
        this.dlvyEndSlct = dlvyEndSlct;
    }

    public Instant getDlvyStTime() {
        return dlvyStTime;
    }

    public void setDlvyStTime(Instant dlvyStTime) {
        this.dlvyStTime = dlvyStTime;
    }

    public String getDlvyTitle() {
        return dlvyTitle;
    }

    public void setDlvyTitle(String dlvyTitle) {
        this.dlvyTitle = dlvyTitle;
    }

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Integer getMenuBoxNo() {
        return menuBoxNo;
    }

    public void setMenuBoxNo(Integer menuBoxNo) {
        this.menuBoxNo = menuBoxNo;
    }

    public Character getMenuYn() {
        return menuYn;
    }

    public void setMenuYn(Character menuYn) {
        this.menuYn = menuYn;
    }

    public Character getPaySlct() {
        return paySlct;
    }

    public void setPaySlct(Character paySlct) {
        this.paySlct = paySlct;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

}
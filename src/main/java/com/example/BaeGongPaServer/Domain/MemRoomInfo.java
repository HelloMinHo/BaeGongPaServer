package com.example.BaeGongPaServer.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "mem_room_info")
public class MemRoomInfo {
    @Id
    @Column(name = "key_no", nullable = false)
    private Integer id;

    @Column(name = "cncl_cnt", nullable = false)
    private Integer cnclCnt;

    @Column(name = "host_yn", nullable = false)
    private Character hostYn;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "mem_no", nullable = false)
    private Integer memNo;

    @Column(name = "room_no", nullable = false)
    private Integer roomNo;

    @Column(name = "succ_cnt", nullable = false)
    private Integer succCnt;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCnclCnt() {
        return cnclCnt;
    }

    public void setCnclCnt(Integer cnclCnt) {
        this.cnclCnt = cnclCnt;
    }

    public Character getHostYn() {
        return hostYn;
    }

    public void setHostYn(Character hostYn) {
        this.hostYn = hostYn;
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

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getSuccCnt() {
        return succCnt;
    }

    public void setSuccCnt(Integer succCnt) {
        this.succCnt = succCnt;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

}
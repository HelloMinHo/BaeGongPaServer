package com.example.BaeGongPaServer.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "mem_detail")
public class MemDetail {
    @Id
    @Column(name = "mem_no", nullable = false)
    private Integer id;

    @Column(name = "cncl_cnt", nullable = false)
    private Integer cnclCnt;

    @Column(name = "host_cnt", nullable = false)
    private Integer hostCnt;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "room_cnt", nullable = false)
    private Integer roomCnt;

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

    public Integer getHostCnt() {
        return hostCnt;
    }

    public void setHostCnt(Integer hostCnt) {
        this.hostCnt = hostCnt;
    }

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
    }

    public Integer getRoomCnt() {
        return roomCnt;
    }

    public void setRoomCnt(Integer roomCnt) {
        this.roomCnt = roomCnt;
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
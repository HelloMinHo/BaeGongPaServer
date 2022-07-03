package com.example.BaeGongPaServer.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "mem_dlvy_info")
public class MemDlvyInfo {
    @Id
    @Column(name = "key_no", nullable = false)
    private Integer id;

    @Column(name = "dlvy_no", nullable = false)
    private Integer dlvyNo;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "mem_no", nullable = false)
    private Integer memNo;

    @Column(name = "menu_box_no", nullable = false)
    private Integer menuBoxNo;

    @Column(name = "menu_no", nullable = false)
    private Integer menuNo;

    @Column(name = "my_pay_yn", nullable = false)
    private Character myPayYn;

    @Column(name = "pay_date", nullable = false)
    private Instant payDate;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDlvyNo() {
        return dlvyNo;
    }

    public void setDlvyNo(Integer dlvyNo) {
        this.dlvyNo = dlvyNo;
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

    public Integer getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Integer menuNo) {
        this.menuNo = menuNo;
    }

    public Character getMyPayYn() {
        return myPayYn;
    }

    public void setMyPayYn(Character myPayYn) {
        this.myPayYn = myPayYn;
    }

    public Instant getPayDate() {
        return payDate;
    }

    public void setPayDate(Instant payDate) {
        this.payDate = payDate;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

}
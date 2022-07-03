package com.example.BaeGongPaServer.Domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "mem_info")
public class MemInfo {
    @Id
    @Column(name = "mem_no", nullable = false)
    private Integer memNo;

    @Column(name = "auth_slct", nullable = false)
    private Character authSlct;

    @Column(name = "auth_yn", nullable = false)
    private Character authYn;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "mem_id", nullable = false)
    private String memId;

    @Column(name = "mem_name", nullable = false)
    private String memName;

    @Column(name = "mem_phone", nullable = false)
    private String memPhone;

    @Column(name = "mem_pwd", nullable = false)
    private String memPwd;

    @Column(name = "mem_sex", nullable = false)
    private Character memSex;
=======
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mem_info")
@DynamicInsert
public class MemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_no", nullable = false)
    private Integer memNo;

    @Column(name = "mem_id", nullable = false)
    private String memId;

    @Column(name = "mem_pwd", nullable = false)
    private String memPwd;

    @Column(name = "mem_nick", nullable = false, length = 100)
    private String memNick;

    @Column(name = "mem_bg_photo", nullable = false)
    private String memBgPhoto;

    @Column(name = "mem_pf_photo", nullable = false)
    private String memPfPhoto;

    @Column(name = "mem_roll", nullable = false)
    private Integer memRoll;

    @Column(name = "auth_slct", nullable = false)
    private Character authSlct;

    @Column(name = "auth_phone", nullable = false, length = 20)
    private String authPhone;

    @Column(name = "auth_name", nullable = false, length = 20)
    private String authName;

    @Column(name = "auth_date", nullable = false)
    private Instant authDate;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

<<<<<<< HEAD
=======
    @OneToMany(mappedBy = "hostMemNo")
    private Set<RoomInfo> roomInfos = new LinkedHashSet<>();

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

<<<<<<< HEAD
    public Character getAuthSlct() {
        return authSlct;
    }

    public void setAuthSlct(Character authSlct) {
        this.authSlct = authSlct;
    }

    public Character getAuthYn() {
        return authYn;
    }

    public void setAuthYn(Character authYn) {
        this.authYn = authYn;
    }

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public Character getMemSex() {
        return memSex;
    }

    public void setMemSex(Character memSex) {
        this.memSex = memSex;
=======
    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public String getMemNick() {
        return memNick;
    }

    public void setMemNick(String memNick) {
        this.memNick = memNick;
    }

    public String getMemBgPhoto() {
        return memBgPhoto;
    }

    public void setMemBgPhoto(String memBgPhoto) {
        this.memBgPhoto = memBgPhoto;
    }

    public String getMemPfPhoto() {
        return memPfPhoto;
    }

    public void setMemPfPhoto(String memPfPhoto) {
        this.memPfPhoto = memPfPhoto;
    }

    public Integer getMemRoll() {
        return memRoll;
    }

    public void setMemRoll(Integer memRoll) {
        this.memRoll = memRoll;
    }

    public Character getAuthSlct() {
        return authSlct;
    }

    public void setAuthSlct(Character authSlct) {
        this.authSlct = authSlct;
    }

    public String getAuthPhone() {
        return authPhone;
    }

    public void setAuthPhone(String authPhone) {
        this.authPhone = authPhone;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public Instant getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Instant authDate) {
        this.authDate = authDate;
    }

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

<<<<<<< HEAD
=======
    public Set<RoomInfo> getRoomInfos() {
        return roomInfos;
    }

    public void setRoomInfos(Set<RoomInfo> roomInfos) {
        this.roomInfos = roomInfos;
    }



>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
}
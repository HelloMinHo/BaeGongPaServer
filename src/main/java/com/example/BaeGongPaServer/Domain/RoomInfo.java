package com.example.BaeGongPaServer.Domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "room_info")
public class RoomInfo {
    @Id
    @Column(name = "room_no", nullable = false)
    private Integer id;

    @Column(name = "addr_detail", nullable = false)
    private String addrDetail;
=======
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "room_info")
@DynamicInsert
@DynamicUpdate
public class RoomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no", nullable = false)
    private Long id;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "room_sub", nullable = false)
    private String roomSub;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144

    @Column(name = "area_l_code", nullable = false)
    private Integer areaLCode;

    @Column(name = "area_m_code", nullable = false)
    private Integer areaMCode;

    @Column(name = "area_s_code", nullable = false)
    private Integer areaSCode;

<<<<<<< HEAD
    @Column(name = "hash_tag", nullable = false)
    private String hashTag;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "invite_code", nullable = false)
    private String inviteCode;

    @Column(name = "mem_no", nullable = false)
    private Integer memNo;

    @Column(name = "menu_cnt", nullable = false)
    private Integer menuCnt;

    @Column(name = "room_conts", nullable = false)
    private String roomConts;

    @Column(name = "room_mem_cnt", nullable = false)
    private Integer roomMemCnt;

    @Column(name = "room_title", nullable = false)
    private String roomTitle;

    @Column(name = "succ_cnt", nullable = false)
    private Integer succCnt;
=======
    @Column(name = "addr_detail", nullable = false)
    private String addrDetail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "host_mem_no", nullable = false)
    private MemInfo hostMemNo;

    @Column(name = "sub_mem_no", nullable = false)
    private Integer subMemNo;

    @Column(name = "invite_code", nullable = false, length = 20)
    private String inviteCode;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

<<<<<<< HEAD
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
=======
    @OneToMany(mappedBy = "roomNo")
    private Set<MenuBoxInfo> menuBoxInfos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "roomNo")
    private Set<OrderInfo> orderInfos = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomSub() {
        return roomSub;
    }

    public void setRoomSub(String roomSub) {
        this.roomSub = roomSub;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    }

    public Integer getAreaLCode() {
        return areaLCode;
    }

    public void setAreaLCode(Integer areaLCode) {
        this.areaLCode = areaLCode;
    }

    public Integer getAreaMCode() {
        return areaMCode;
    }

    public void setAreaMCode(Integer areaMCode) {
        this.areaMCode = areaMCode;
    }

    public Integer getAreaSCode() {
        return areaSCode;
    }

    public void setAreaSCode(Integer areaSCode) {
        this.areaSCode = areaSCode;
    }

<<<<<<< HEAD
    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Integer getMenuCnt() {
        return menuCnt;
    }

    public void setMenuCnt(Integer menuCnt) {
        this.menuCnt = menuCnt;
    }

    public String getRoomConts() {
        return roomConts;
    }

    public void setRoomConts(String roomConts) {
        this.roomConts = roomConts;
    }

    public Integer getRoomMemCnt() {
        return roomMemCnt;
    }

    public void setRoomMemCnt(Integer roomMemCnt) {
        this.roomMemCnt = roomMemCnt;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
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
=======
    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public MemInfo getHostMemNo() {
        return hostMemNo;
    }

    public void setHostMemNo(MemInfo hostMemNo) {
        this.hostMemNo = hostMemNo;
    }

    public Integer getSubMemNo() {
        return subMemNo;
    }

    public void setSubMemNo(Integer subMemNo) {
        this.subMemNo = subMemNo;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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

    public Set<MenuBoxInfo> getMenuBoxInfos() {
        return menuBoxInfos;
    }

    public void setMenuBoxInfos(Set<MenuBoxInfo> menuBoxInfos) {
        this.menuBoxInfos = menuBoxInfos;
    }

    public Set<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(Set<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    }

}
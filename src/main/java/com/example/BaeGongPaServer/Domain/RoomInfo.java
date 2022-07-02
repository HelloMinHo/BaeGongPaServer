package com.example.BaeGongPaServer.Domain;

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

    @Column(name = "area_l_code", nullable = false)
    private Integer areaLCode;

    @Column(name = "area_m_code", nullable = false)
    private Integer areaMCode;

    @Column(name = "area_s_code", nullable = false)
    private Integer areaSCode;

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

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

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
    }

}
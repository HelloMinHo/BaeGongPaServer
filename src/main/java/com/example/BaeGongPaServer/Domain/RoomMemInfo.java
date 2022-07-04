package com.example.BaeGongPaServer.Domain;

import lombok.Builder;
import lombok.Data;
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
@Data
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "host_mem_no", nullable = false)
    private MemInfo hostMemNo;


    @Column(name = "sub_mem_no", nullable = false)
    private Long subMemNo;

    @Column(name = "invite_code", nullable = false, length = 20)
    private String inviteCode;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

    public RoomInfo() {
    }

    public RoomInfo(String roomName, String roomSub, Integer areaLCode, Integer areaMCode, Integer areaSCode, String addrDetail, MemInfo hostMemNo, Long subMemNo, String inviteCode, Instant insDate, Instant updDate) {
        this.roomName = roomName;
        this.roomSub = roomSub;
        this.areaLCode = areaLCode;
        this.areaMCode = areaMCode;
        this.areaSCode = areaSCode;
        this.addrDetail = addrDetail;
        this.hostMemNo = hostMemNo;
        this.subMemNo = subMemNo;
        this.inviteCode = inviteCode;
        this.insDate = insDate;
        this.updDate = updDate;
    }
}
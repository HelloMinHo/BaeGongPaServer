package com.example.BaeGongPaServer.Domain;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name = "room_no")
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_sub")
    private String roomSub;

    @Column(name = "area_l_code")
    private Integer areaLCode;

    @Column(name = "area_m_code")
    private Integer areaMCode;

    @Column(name = "area_s_code")
    private Integer areaSCode;

    @Column(name = "addr_detail")
    private String addrDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "host_mem_no")
    private MemInfo hostMemNo;


    @Column(name = "sub_mem_no")
    private Long subMemNo;

    @Column(name = "invite_code", length = 20)
    private String inviteCode;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;

    public RoomInfo() {
    }

    public RoomInfo(String roomName, String roomSub, Integer areaLCode, Integer areaMCode, Integer areaSCode, String addrDetail, MemInfo hostMemNo, Long subMemNo, String inviteCode, LocalDateTime insDate, LocalDateTime updDate) {
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
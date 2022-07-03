package com.example.BaeGongPaServer.Domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "menu_box_info")
@DynamicInsert
@DynamicUpdate
public class MenuBoxInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_box_no", nullable = false)
    private Long id;

    @Column(name = "menu_box_name", nullable = false, length = 50)
    private String menuBoxName;

    @Column(name = "menu_box_sub", nullable = false, length = 50)
    private String menuBoxSub;

    @Column(name = "menu_cnt", nullable = false)
    private Integer menuCnt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_no", nullable = false)
    private RoomInfo roomNo;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

    @OneToMany(mappedBy = "menuBoxNo")
    private Set<MenuInfo> menuInfos = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuBoxName() {
        return menuBoxName;
    }

    public void setMenuBoxName(String menuBoxName) {
        this.menuBoxName = menuBoxName;
    }

    public String getMenuBoxSub() {
        return menuBoxSub;
    }

    public void setMenuBoxSub(String menuBoxSub) {
        this.menuBoxSub = menuBoxSub;
    }

    public Integer getMenuCnt() {
        return menuCnt;
    }

    public void setMenuCnt(Integer menuCnt) {
        this.menuCnt = menuCnt;
    }

    public RoomInfo getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(RoomInfo roomNo) {
        this.roomNo = roomNo;
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

    public Set<MenuInfo> getMenuInfos() {
        return menuInfos;
    }

    public void setMenuInfos(Set<MenuInfo> menuInfos) {
        this.menuInfos = menuInfos;
    }

}
package com.example.BaeGongPaServer.Domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "menu_box_info")
public class MenuBoxInfo {
    @Id
    @Column(name = "menu_box_no", nullable = false)
    private Integer id;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "menu_box_name", nullable = false)
    private String menuBoxName;

    @Column(name = "menu_cnt", nullable = false)
    private Integer menuCnt;

    @Column(name = "room_no", nullable = false)
    private Integer roomNo;
=======
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

    public Instant getInsDate() {
        return insDate;
    }

    public void setInsDate(Instant insDate) {
        this.insDate = insDate;
    }

=======
    @OneToMany(mappedBy = "menuBoxNo")
    private Set<MenuInfo> menuInfos = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    public String getMenuBoxName() {
        return menuBoxName;
    }

    public void setMenuBoxName(String menuBoxName) {
        this.menuBoxName = menuBoxName;
    }

<<<<<<< HEAD
=======
    public String getMenuBoxSub() {
        return menuBoxSub;
    }

    public void setMenuBoxSub(String menuBoxSub) {
        this.menuBoxSub = menuBoxSub;
    }

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    public Integer getMenuCnt() {
        return menuCnt;
    }

    public void setMenuCnt(Integer menuCnt) {
        this.menuCnt = menuCnt;
    }

<<<<<<< HEAD
    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

=======
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

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

<<<<<<< HEAD
=======
    public Set<MenuInfo> getMenuInfos() {
        return menuInfos;
    }

    public void setMenuInfos(Set<MenuInfo> menuInfos) {
        this.menuInfos = menuInfos;
    }

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
}
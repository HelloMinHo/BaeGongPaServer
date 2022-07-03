package com.example.BaeGongPaServer.Domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
=======
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
import java.time.Instant;

@Entity
@Table(name = "menu_info")
<<<<<<< HEAD
public class MenuInfo {
    @Id
    @Column(name = "menu_no", nullable = false)
    private Integer id;

    @Column(name = "ins_date", nullable = false)
    private Instant insDate;

    @Column(name = "menu_box_no", nullable = false)
    private Integer menuBoxNo;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "menu_price", nullable = false)
    private Integer menuPrice;

    @Column(name = "menu_slct", nullable = false)
    private Character menuSlct;
=======
@DynamicInsert
@DynamicUpdate
public class MenuInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_no", nullable = false)
    private Long id;

    @Column(name = "menu_name", nullable = false, length = 50)
    private String menuName;

    @Column(name = "menu_sub", nullable = false, length = 50)
    private String menuSub;

    @Column(name = "menu_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal menuPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_box_no", nullable = false)
    private MenuBoxInfo menuBoxNo;

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

    public Integer getMenuBoxNo() {
        return menuBoxNo;
    }

    public void setMenuBoxNo(Integer menuBoxNo) {
        this.menuBoxNo = menuBoxNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Character getMenuSlct() {
        return menuSlct;
    }

    public void setMenuSlct(Character menuSlct) {
        this.menuSlct = menuSlct;
=======
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuSub() {
        return menuSub;
    }

    public void setMenuSub(String menuSub) {
        this.menuSub = menuSub;
    }

    public BigDecimal getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(BigDecimal menuPrice) {
        this.menuPrice = menuPrice;
    }

    public MenuBoxInfo getMenuBoxNo() {
        return menuBoxNo;
    }

    public void setMenuBoxNo(MenuBoxInfo menuBoxNo) {
        this.menuBoxNo = menuBoxNo;
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

}
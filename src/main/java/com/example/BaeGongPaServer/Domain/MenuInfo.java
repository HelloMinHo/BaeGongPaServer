package com.example.BaeGongPaServer.Domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "menu_info")
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

    @Column(name = "upd_date", nullable = false)
    private Instant updDate;

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
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

}
package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu_info")
@DynamicInsert
@DynamicUpdate
@Data
public class MenuInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_no")
    private Long id;

    @Column(name = "menu_name", length = 50)
    private String menuName;

    @Column(name = "menu_sub", length = 50)
    private String menuSub;

    @Column(name = "menu_price", precision = 10, scale = 2)
    private BigDecimal menuPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_box_no")
    private MenuBoxInfo menuBoxNo;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;


}
package com.example.BaeGongPaServer.Domain;

import lombok.Data;
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
@Data
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

}
package com.example.BaeGongPaServer.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name = "menu_box_no")
    private Long id;

    @Column(name = "menu_box_name", length = 50)
    private String menuBoxName;

    @Column(name = "menu_box_sub", length = 50)
    private String menuBoxSub;

    @Column(name = "menu_cnt")
    private Integer menuCnt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_no")
    private RoomInfo roomNo;

    @Column(name = "ins_date")
    private LocalDateTime insDate;

    @Column(name = "upd_date")
    private LocalDateTime updDate;

}
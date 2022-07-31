package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.DomainId.RoomMemInfoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.time.LocalDateTime;
import java.util.List;

public interface RoomInfoRepository extends JpaRepository<RoomInfo, RoomMemInfoId> {

    RoomInfo save(RoomInfo roomInfo);

    @Query("select r from RoomInfo r where r.hostMemNo = ?1")
    Page<RoomInfo> findByHostMemNo(MemInfo hostMemNo, Pageable pageable);


//    @Query("select r from RoomInfo r join fetch r.hostMemNo where r.insDate between ?1 and ?2")
//    List<RoomInfo> findByInsDateBetween(LocalDateTime stDate, LocalDateTime enDate);

    @Query("select r,m from RoomInfo r left join r.hostMemNo m where r.updDate between ?1 and ?2 ")
    Page<RoomInfo> findByUpdDateBetween(LocalDateTime stDate, LocalDateTime enDate, Pageable pageable);

//    @Query("select "
//            + " r.id AS id, r.roomName AS roomName, r.roomSub AS roomSub, r.areaLCode AS areaLCode "
//            + " , r.areaMCode AS areaMCode, r.areaSCode AS areaSCode, r.addrDetail AS addrDetail "
//            + " , r.subMemNo AS subMemNo, r.insDate AS insDate, r.updDate AS updDate  "
//            + " , m.memNo, m.memNick, m.memPfPhoto "
//            + " from RoomInfo r left join r.hostMemNo m "
//            + " where r.updDate between ?1 and ?2 ")
//    Page<RoomInfo> findByUpdDateBetween(LocalDateTime stDate, LocalDateTime enDate, Pageable pageable);





}
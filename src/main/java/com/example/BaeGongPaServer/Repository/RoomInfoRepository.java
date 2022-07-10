package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.DomainId.RoomMemInfoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomInfoRepository extends JpaRepository<RoomInfo, RoomMemInfoId> {

    RoomInfo save(RoomInfo roomInfo);

    @Query("select r from RoomInfo r join fetch r.hostMemNo where r.hostMemNo = ?1")
    List<RoomInfo> findByHostMemNo(MemInfo hostMemNo);


    @Query("select r from RoomInfo r join fetch r.hostMemNo where r.insDate between ?1 and ?2")
    List<RoomInfo> findByInsDateBetween(LocalDateTime stDate, LocalDateTime enDate);




}
package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface RoomInfoRepository extends JpaRepository<RoomInfo, Long> {

    RoomInfo save(RoomInfo roomInfo);

    List<RoomInfo> findByHostMemNo(MemInfo hostMemNo);


    @Query("select r from RoomInfo r join fetch r.hostMemNo where r.insDate between ?1 and ?2")
    List<RoomInfo> findByInsDateBetween(Instant stDate, Instant enDate);
}
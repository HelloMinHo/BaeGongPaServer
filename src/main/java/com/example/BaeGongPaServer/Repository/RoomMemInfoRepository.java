package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.RoomMemInfo;
import com.example.BaeGongPaServer.DomainId.RoomMemInfoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomMemInfoRepository extends JpaRepository<RoomMemInfo, RoomMemInfoId> {


    @EntityGraph(attributePaths = {"memNo"})
    List<RoomMemInfo> findByRoomNo(Long roomNo);

    @Query("select r from RoomMemInfo r where r.memNo = ?1 ")
    Page<RoomMemInfo> findByMemNo(MemInfo memInfo, Pageable pageable);

    @Override
    List<RoomMemInfo> findAll();

    RoomMemInfo save(RoomMemInfo roomMemInfo);
}
package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.RoomInfo;
import com.example.BaeGongPaServer.Domain.RoomMemInfo;
import com.example.BaeGongPaServer.DomainId.RoomMemInfoId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomMemInfoRepository extends JpaRepository<RoomMemInfo, RoomMemInfoId> {


    @EntityGraph(attributePaths = {"memNo"})
    List<RoomMemInfo> findByRoomNo(Long roomNo);

    @Override
    List<RoomMemInfo> findAll();
}
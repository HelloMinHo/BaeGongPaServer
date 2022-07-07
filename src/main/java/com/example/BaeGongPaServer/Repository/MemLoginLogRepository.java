package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemLoginLog;
import com.example.BaeGongPaServer.Domain.RoomMemInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemLoginLogRepository extends JpaRepository<MemLoginLog, Long> {
//    @EntityGraph(attributePaths = {"memNo"})
//    List<RoomMemInfo> findByRoomNo(Long roomNo);
//
//    @Override
//    List<RoomMemInfo> findAll();

    MemLoginLog save(MemLoginLog memLoginLog);
}

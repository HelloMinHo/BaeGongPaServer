package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemRoomInfoRepository extends JpaRepository<MemRoomInfo, Integer> {
}
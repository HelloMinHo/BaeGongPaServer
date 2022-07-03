package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.RoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomInfoRepository extends JpaRepository<RoomInfo, Long> {
}
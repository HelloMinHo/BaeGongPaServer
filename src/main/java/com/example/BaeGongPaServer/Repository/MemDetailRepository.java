package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemDetailRepository extends JpaRepository<MemDetail, Integer>, JpaSpecificationExecutor<MemDetail> {
}
package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemInfoRepository extends JpaRepository<MemInfo, Integer>, JpaSpecificationExecutor<MemInfo> {

    MemInfo findByMemIdAndMemPwd(String memId, String memPwd);

    MemInfo findByMemId(String memId);

    MemInfo save(MemInfo memInfo);

}
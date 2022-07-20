package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemInfoRepository extends JpaRepository<MemInfo, Long> {

    @Query("select m from MemInfo m where m.memId = ?1 and m.memPwd = ?2")
    MemInfo findByMemIdAndMemPwd(String memId, String memPwd);

    boolean existsByMemNick(String memNick);

    boolean existsByMemId(String memId);

    MemInfo findByMemId(String memId);

    MemInfo findByMemNo(Long memNo);

}
package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.MemSess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemSessRepository extends JpaRepository<MemSess, Long> {

    MemSess findByMemNo(Long memNo);

    //MemInfo save(MemInfo memInfo);

    @Modifying
    @Query("update MemInfo m set m.fcmToken = ?2 where m.memNo = ?1")
    int updateFcmTokenByMemNo(Long memNo, String fcmToken);


}
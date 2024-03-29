package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.MemSess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemSessRepository extends JpaRepository<MemSess, Long> {

    MemSess findByMemNo(Long memNo);

    MemSess save(MemSess memSess);

    @Modifying
    @Query("update MemSess m set m.fcmToken = ?2 where m.memNo = ?1")
    void updateFcmTokenByMemNo(Long memNo, String fcmToken);


}
package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface MemInfoRepository extends JpaRepository<MemInfo, Integer> {

    MemInfo findByMemId(String memId);
    MemInfo findByMemIdAndMemPwd(String memId, String memPwd);
=======
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemInfoRepository extends JpaRepository<MemInfo, Integer>, JpaSpecificationExecutor<MemInfo> {

    MemInfo findByMemIdAndMemPwd(String memId, String memPwd);

    MemInfo findByMemId(String memId);

    MemInfo save(MemInfo memInfo);

>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
}
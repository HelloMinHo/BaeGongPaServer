package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MemLoginLog;
import com.example.BaeGongPaServer.Domain.MemPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemPhotoRepository extends JpaRepository<MemPhoto, Long> {

    MemPhoto save(MemPhoto memPhoto);
}

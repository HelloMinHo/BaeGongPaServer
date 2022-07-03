package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.MenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuInfoRepository extends JpaRepository<MenuInfo, Long> {
}
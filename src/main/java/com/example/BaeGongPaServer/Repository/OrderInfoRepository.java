package com.example.BaeGongPaServer.Repository;

import com.example.BaeGongPaServer.Domain.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
}
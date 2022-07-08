package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.Domain.OrderInfo;
import com.example.BaeGongPaServer.Repository.OrderInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderInfoService {

    private final OrderInfoRepository orderInfoRepository;

    public ApiResponse createOrderInfo(OrderInfo orderInfo) {

        // ModelMapper modelMapper = new ModelMapper();

        return  null;
    }
}

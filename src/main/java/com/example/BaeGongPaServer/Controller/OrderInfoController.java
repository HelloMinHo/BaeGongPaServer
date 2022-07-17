package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.OrderInfoDTO;
import com.example.BaeGongPaServer.Domain.OrderInfo;
import com.example.BaeGongPaServer.Service.OrderInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderInfoController {

    private  final OrderInfoService orderInfoService;

    @RequestMapping(value = "/order/create")
    public ApiResponse createOrderInfo(@ModelAttribute OrderInfoDTO orderInfoDto) {

        OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setOrderName(orderInfo.get);
//        orderInfoService.createOrderInfo()

        return null;
    }
}

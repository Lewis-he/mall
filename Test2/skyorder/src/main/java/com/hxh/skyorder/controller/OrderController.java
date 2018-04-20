package com.hxh.skyorder.controller;

import com.hxh.skyorder.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService os;

    @RequestMapping("toOrder")
    @ResponseBody
    public String toOrder(){
        return "开始下订单";
    }

}

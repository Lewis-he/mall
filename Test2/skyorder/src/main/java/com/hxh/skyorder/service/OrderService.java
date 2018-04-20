package com.hxh.skyorder.service;

import com.alibaba.fastjson.JSON;
import com.hxh.skyorder.dao.OrderDao;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class OrderService {

    @Resource
    private OrderDao od;

    @Transactional//开启事务
    @JmsListener(destination = "mall_cart")
    public void saveOrder(String json){

        System.out.println(json);
        Map map = JSON.parseObject(json, Map.class);
//        System.out.println(map.get());
        System.out.println(map.get("out_trade_no") + "--:--"+map.get("total_amount"));
        od.saveOrder(map);
        od.saveOrderDetail(map);

    }

}

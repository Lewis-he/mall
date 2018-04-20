package com.hxh.cart.controller;

import com.alibaba.fastjson.JSON;
import com.hxh.cart.entity.Commodity;
import com.hxh.cart.service.CartService;
import com.hxh.cart.service.OrderService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private CartService cs;

    @Resource
    private OrderService os;

    @Resource
    private JmsTemplate jmsTemplate;

    @RequestMapping("saveOrder")
    @ResponseBody
    public String saveOrder(@CookieValue(required = false) String cart){
        String orderCode = UUID.randomUUID().toString().replace("-","");

        Map<String,Commodity> map = cs.getCart(cart);

        float total = cs.total(map);

        Map<String,Object> data = new HashMap<>();

        data.put("out_trade_no",orderCode);
        data.put("total_amount",total);
        data.put("subject","你的订单");
        data.put("body","body");
        data.put("product_code","FAST_INSTANT_TRADE_PAY");

        String json1 = JSON.toJSONString(data);

        //支付
        String result = os.pay(json1);
        //把详情放到要发送的数据内
        data.put("detail",map.values());
        //转为json
        String json2 = JSON.toJSONString(data);
        //发消息
        jmsTemplate.convertAndSend("mall_cart",json2);
        return result;
    }

//支付完成显示的页面
    @RequestMapping("payback")
    public String payback(){
        return "payend";
    }
}

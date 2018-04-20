package com.hxh.cart.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hxh.cart.HttpUtils.Base64Util;
import com.hxh.cart.HttpUtils.JsonUtil;
import com.hxh.cart.entity.Commodity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class CartService {


    public void addCart(String sku, Model model, String cookie, HttpServletResponse resp) {
        Map<String,Commodity> car = null;
        if(StringUtils.isEmpty(cookie)){

            car = new HashMap<>();
        }else {

            String json = Base64Util.decode(cookie);
            car = JSON.parseObject(json,new TypeReference<Map<String,Commodity>>(){});

        }

        if (car.containsKey(sku)){
            Commodity commodity = car.get(sku);
            commodity.setBuy_num(commodity.getBuy_num()+1);
        }else {
            String path = "http://localhost:8081/commodity/findCommodityBySku/" + sku;
            String json = JsonUtil.getJsonString(path);
            Commodity commodity = JSON.parseObject(json, Commodity.class);
            commodity.setBuy_num(1);
            car.put(sku,commodity);
        }

        model.addAttribute("car",car.values());
        model.addAttribute("total",total(car));
        addCart(resp,car);

    }


    public float update(int num, String sku, String cookie, HttpServletResponse resp) {
        Map<String, Commodity> cart = getCart(cookie);

        Commodity commodity = cart.get(sku);

        commodity.setBuy_num(num);

        addCart(resp,cart);

        return total(cart);
    }

    private void addCart(HttpServletResponse response,Map<String, Commodity> cart){
        String jsonString = JSON.toJSONString(cart);

        Cookie cookie = new Cookie("cart", Base64Util.encode(jsonString));
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public Map<String,Commodity> getCart(String cookie){

        String json = Base64Util.decode(cookie);
        Map<String, Commodity> stringCommodityMap = JSON.parseObject(json, new TypeReference<Map<String, Commodity>>() {
        });

        return stringCommodityMap;
    }

    public float total(Map<String,Commodity> cart){
        float total=0;
        Collection<Commodity> values = cart.values();

        for (Commodity comm: values) {
            total += comm.getBuy_num()*comm.getPrice();
        }

        return total;
    }

    public void lookCart(String cookie, Model model) {

        if (cookie!=null){
            Map<String,Commodity> cart = getCart(cookie);
            model.addAttribute("cart",cart.values());
            model.addAttribute("total",total(cart));
        }else {
            model.addAttribute("cart",null);
            model.addAttribute("total",0);
        }



    }

    public void delete(String cookie, String sku, Model model, HttpServletResponse resp) {
        Map<String,Commodity> cart = getCart(cookie);
        cart.remove(sku);

        if (!cart.isEmpty()){
            addCart(resp,cart);
            model.addAttribute("cart",cart.values());
            model.addAttribute("total",total(cart));
        }else {
            model.addAttribute("cart",null);
            model.addAttribute("total",0);
        }
    }
}

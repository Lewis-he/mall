package com.hxh.restful.controller;

import com.hxh.restful.entity.Commodity;
import com.hxh.restful.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("commodity")
public class CommodityController {
    @Resource
    private CommodityService cs;

    @RequestMapping("findCommodityBySku/{sku}")
    @ResponseBody
    public Commodity findCommodityBySku(@PathVariable String sku){
        return cs.findCommodityBySku(sku);
    }
}

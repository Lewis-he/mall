package com.hxh.restful.service;

import com.hxh.restful.dao.CommodityDao;
import com.hxh.restful.entity.Commodity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityService {
    @Resource
    private CommodityDao cd;


    public Commodity findCommodityBySku(String sku) {

        return cd.findCommodityBySku(sku);
    }
}

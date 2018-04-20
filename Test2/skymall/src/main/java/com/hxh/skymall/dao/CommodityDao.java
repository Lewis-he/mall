package com.hxh.skymall.dao;

import com.hxh.skymall.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommodityDao {
    void addCommodityInfo(Map<String, Object> param);

    void addCommodityImg(Map<String, Object> param);

    List<Commodity> findAllCommodity();

    Commodity findCommodityBySku(String sku);
}

package com.hxh.restful.dao;

import com.hxh.restful.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommodityDao {

    Commodity findCommodityBySku(String sku);
}

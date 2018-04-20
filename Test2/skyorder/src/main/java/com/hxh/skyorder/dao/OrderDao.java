package com.hxh.skyorder.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface OrderDao {
    void saveOrder(Map map);

    void saveOrderDetail(Map map);
}

package com.hxh.skymall.dao;

import com.hxh.skymall.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RoleDao {
    void addResource(Map<String, Object> map);

    List<Role> findAllRole();
}

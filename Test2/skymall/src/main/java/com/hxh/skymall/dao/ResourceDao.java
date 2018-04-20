package com.hxh.skymall.dao;

import com.hxh.skymall.entity.Resource;
import com.hxh.skymall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ResourceDao {
    List<Resource> findAllResource();


    List<Resource> userPrivileges(User user);

    void addResource(Map<String,Object> resource);

    void updateResource(Resource resource);

    List<Resource> allParentPath();
}

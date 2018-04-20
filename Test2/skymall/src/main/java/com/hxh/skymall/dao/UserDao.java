package com.hxh.skymall.dao;

import com.hxh.skymall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {
    List<User> findAllUser();

    void removeMany(List<String> list);

    List<User> fndUserAndRole();

    List<User> searchUserByKey(Map<String, Object> map);

    int readTotal();

    List<User> fenye(Map<String, Integer> map);


    User findUserByName(Map<String, String> map);

    User findUserByUsername(String name);

    void addUser(Map<String,String> user);

    void updateUser(Map<String,String> user);
}

package com.hxh.skymall.service;

import com.hxh.skymall.dao.UserDao;
import com.hxh.skymall.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    private UserDao ud ;

    public List<User> findAllUser() {
        return ud.findAllUser();
    }

    public void removeMany(List<String> list) {
        ud.removeMany(list);
    }

    public List<User> findUserAndRole() {
        return ud.fndUserAndRole();
    }

    public List<User> searchUserByKey(String type, String key) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type",type);
        map.put("key",key);
        return ud.searchUserByKey(map);
    }

    public int readTotal() {
        return ud.readTotal();
    }

    public List<User> fenye(int page, int size) {
        int start = (page-1)*size;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start",start);
        map.put("size",size);
        return ud.fenye(map);
    }

    public User login(String name, String pwd) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name",name);
        map.put("pwd",pwd);
        return ud.findUserByName(map);

    }

    public User findUserByUsername(String name) {

        return ud.findUserByUsername(name);
    }

    public void addUser(Map<String,String> user) {
        ud.addUser(user);
    }

    public void updateUser(Map<String,String> user) {
        ud.updateUser(user);
    }
}

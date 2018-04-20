package com.hxh.skymall.service;

import com.hxh.skymall.dao.RoleDao;
import com.hxh.skymall.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleDao rd ;
    public void addResource(String[] s) {

        List<String> list = new ArrayList<String>();

        for (int i=1; i < s.length; i++){
            list.add(s[i]);
        }

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("rid",s[0]);
        map.put("tids",list);

        rd.addResource(map);
    }

    public List<Role> allRole() {
       return rd.findAllRole();
    }
}

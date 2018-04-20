package com.hxh.skymall.controller;

import com.hxh.skymall.entity.Role;
import com.hxh.skymall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService rs ;

    @RequestMapping("allRole")
    @ResponseBody
    public List<Role> allRole(){
        return rs.allRole();
    }
    @RequestMapping("add/{roleids}")
    @ResponseBody
    public String add(@PathVariable String roleids){

        String[] s=roleids.split(",");

        rs.addResource(s);

        return "1";
    }
}

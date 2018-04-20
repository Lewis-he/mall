package com.hxh.skymall.controller;


import com.hxh.skymall.entity.Resource;
import com.hxh.skymall.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ResourceController {
    @Autowired
    private ResourceService ts ;

    @RequestMapping("findAllResource")
    @ResponseBody
    public List<Resource> findAllTool(){
        return ts.findAllTool();
    }

    @RequestMapping("userPrivileges")
    @ResponseBody
    public List<Resource> userPrivileges(HttpSession session){
       return ts.userPrivileges(session);
    }

    @RequestMapping("addResource")
    @ResponseBody
    public String addTool(Map<String,Object> t){
        System.out.println(t.get("text"));
        ts.addTool(t);
        return "1";
    }

    @RequestMapping("updateResource")
    @ResponseBody
    public String updateTool(Resource t){
        ts.updateTool(t);
        return "1";
    }

    @RequestMapping("allParentPath")
    @ResponseBody
    public List<Resource> allParentPath(){

        return ts.allParentPath();
    }
}

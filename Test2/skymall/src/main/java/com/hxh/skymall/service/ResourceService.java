package com.hxh.skymall.service;

import com.hxh.skymall.dao.ResourceDao;
import com.hxh.skymall.entity.Resource;
import com.hxh.skymall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ResourceService {
    @Autowired
    private ResourceDao td ;
    public List<Resource> findAllTool() {
      return  td.findAllResource();
    }


    public List<Resource> userPrivileges(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Resource> userPrivileges = td.userPrivileges(user);

        ArrayList<Resource> userPs = new ArrayList<Resource>();
        userPs.addAll(userPrivileges);

        LinkedList<Resource> userPrivileges2 = new LinkedList<Resource>();

        for (Resource parent:userPs) {
            if (parent.getParentId()==0) {
                userPrivileges2.add(parent);
            }
            for(Resource tool:userPs){
                if (parent.getId()==tool.getParentId()){
                    parent.getChildren().add(tool);
                }
            }
        }
        return userPrivileges2;
    }

    public void addTool(Map<String,Object> t) {
        td.addResource(t);
    }

    public void updateTool(Resource t) {
        td.updateResource(t);
    }

    public List<Resource> allParentPath() {

        return td.allParentPath();
    }
}

package com.hxh.skymall.controller;

import com.hxh.skymall.entity.User;
import com.hxh.skymall.service.UserService;
import com.hxh.skymall.uitls.Constance;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("user")
public class UserController {
    @Resource
    private UserService us ;

    @RequestMapping("login/{name}/{pwd}")
    @ResponseBody
    public String login(@PathVariable String name, @PathVariable String pwd, HttpSession session){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(name,pwd);

        try {
            subject.login(token);
            User user = us.login(name, pwd);
            session.setAttribute("user",user);
            return Constance.RESULT_OK;
        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam Map<String,String> user) {

        System.out.println(user.get("password"));
        User u = us.findUserByUsername(user.get("name"));


        if (u!=null){
            return Constance.RESULT_FAILURE;
        }
        us.addUser(user);
        return Constance.RESULT_OK;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(Map<String,String> user){

        System.out.println(user.get("name"));

        try {
            us.updateUser(user);

        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }
        return Constance.RESULT_OK;
    }
    @RequestMapping("allUser")
    @ResponseBody
    public List<User> findAllUser(){
        List<User> allUser = us.findAllUser();

        return allUser;
    }
    @RequestMapping("removeMany/{data1}")
    @ResponseBody
    public String removeMany(@PathVariable String data1) {

        System.out.println(data1);
        String[] s = data1.split(",");
        List<String> list = Arrays.asList(s);
        us.removeMany(list);
        return "1";

    }

    @RequestMapping("findUserAndRole")
    @ResponseBody
    public List<User> findUserAndRole(){
        return us.findUserAndRole();
    }

    @RequestMapping("searchUserByKey/{type}/{key}")
    @ResponseBody
    public List<User> searchUserByKey(@PathVariable("type") String type,@PathVariable("key") String key) {

        return us.searchUserByKey(type,key);
    }
    @RequestMapping("readTotal")
    @ResponseBody
    public int readTotal(){

        return us.readTotal();
    }

    @RequestMapping("fenye/{page}/{size}")
    @ResponseBody
    public List<User> fenye(@PathVariable int page, @PathVariable int size){

        return us.fenye(page,size);
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "redirect:/login.html";
    }
    @RequestMapping("toNoQx")
    @ResponseBody
    public String noQx(){
        return "没有访问权限";
    }


}



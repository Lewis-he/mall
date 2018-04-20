package com.hxh.sso.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("toLogin")
    public String toLogin(String returnUrl, HttpSession session ,HttpServletResponse response) {

        session.setAttribute("returnUrl",returnUrl);

        return "redirect:login.html";
    }


    @RequestMapping("login")
    @ResponseBody
    public String doLogin(String name,String pwd, HttpServletResponse response,HttpSession session){

        System.out.println(name + pwd);
        if (name.equals("aa") && pwd.equals("aa")){

            String token = UUID.randomUUID().toString().replaceAll("-","");

            redisTemplate.opsForValue().set(token,"aa");

            redisTemplate.expire("token",30, TimeUnit.MINUTES);

            Cookie cookie = new Cookie("token", token);

            cookie.setMaxAge(60*30);

            cookie.setPath("/");

            response.addCookie(cookie);

            try {
                response.sendRedirect(session.getAttribute("returnUrl").toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "-1";

        }

        return "1";
    }

    @RequestMapping("hadToken/{token}")
    @ResponseBody
    public String hadToken(@PathVariable String token){
        Object ob = redisTemplate.opsForValue().get(token);
        return ob == null ? "-1":"1";
    }
}

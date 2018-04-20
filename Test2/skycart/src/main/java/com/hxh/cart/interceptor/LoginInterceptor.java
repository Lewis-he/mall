package com.hxh.cart.interceptor;

import com.hxh.cart.HttpUtils.JsonUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie:cookies) {
            String had = JsonUtil.getJsonString("http://localhost:8084/hadToken/" + cookie.getValue());
            if (had.equals("1")){
                return true;
            }

        }
        response.sendRedirect("http://localhost:8084/toLogin?returnUrl=http://localhost:8083/cart/lookcart");

    return false;
    }
}

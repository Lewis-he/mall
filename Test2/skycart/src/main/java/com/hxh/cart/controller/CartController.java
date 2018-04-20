package com.hxh.cart.controller;


import com.hxh.cart.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cart")
public class CartController {

    @Resource
    private CartService cs;

    @RequestMapping("add/{sku}")
    public String addCart(@PathVariable String sku, Model model, @CookieValue(required = false) String cart, HttpServletResponse resp){


        cs.addCart(sku,model,cart,resp);

        return "cart";
    }
    @RequestMapping("update/{sku}/{num}")
    @ResponseBody
    public float updateCartNum(@PathVariable String sku,@PathVariable int num,@CookieValue(value = "cart",required = false) String cookie, HttpServletResponse resp){


        float total = cs.update(num, sku, cookie, resp);

        return total;
    }

    @RequestMapping("lookcart")
    public String lookCart(@CookieValue(required = false) String cart,Model model){
        cs.lookCart(cart,model);
        return "cart";
    }

    @RequestMapping("delete/{sku}")
    public String deleteCart(@CookieValue(required = false) String cart,@PathVariable String sku, Model model,HttpServletResponse resp){
        cs.delete(cart,sku,model,resp);
        return "cart";
    }
}

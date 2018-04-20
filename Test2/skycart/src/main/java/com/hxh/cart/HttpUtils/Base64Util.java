package com.hxh.cart.HttpUtils;

import java.util.Base64;

public class Base64Util {

    public static String encode(String arg){
      return Base64.getEncoder().encodeToString(arg.getBytes());
    }


    public static String decode(String arg){
        return new String(Base64.getDecoder().decode(arg));
    }

    public static void main(String[] args) {
        System.out.println(decode(encode("{\"12e5694fdb804572ac03a16b0c6ba8be\":{\"amount\":0,\"buy_num\":1,\"category\":\"4\",\"description\":\"<p>1111111</p>\\r\\n\",\"name\":\"1111\",\"price\":1111.0,\"price_all\":0.0,\"sku\":\"12e5694fdb804572ac03a16b0c6ba8be\"}}")));
    }
}

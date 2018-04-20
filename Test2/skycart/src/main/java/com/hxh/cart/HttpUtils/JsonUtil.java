package com.hxh.cart.HttpUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JsonUtil {
    public static String getJsonString(String path){
        try {
            URL url = new URL(path);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String data = null;
            StringBuffer buffer = new StringBuffer();
            while ((data=reader.readLine())!=null){
                buffer.append(data);
            }

            reader.close();
            in.close();
            return buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

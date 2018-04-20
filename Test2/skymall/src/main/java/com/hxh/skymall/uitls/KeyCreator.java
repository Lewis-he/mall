package com.hxh.skymall.uitls;

import java.util.UUID;

public class KeyCreator {
    public static String getKey(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}

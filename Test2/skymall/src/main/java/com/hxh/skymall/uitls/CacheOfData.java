package com.hxh.skymall.uitls;

import com.hxh.skymall.entity.Category2;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CacheOfData {

    public static final Map<String,String> cache = new HashMap<>();

    public static final Map<String,List<Category2>> cache2 =new HashMap<>();
}

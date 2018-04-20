package com.hxh.skymall.service;

import com.alibaba.fastjson.JSON;
import com.hxh.skymall.dao.CategoryDao;
import com.hxh.skymall.entity.Category;
import com.hxh.skymall.entity.Category2;
import com.hxh.skymall.uitls.CacheOfData;
import com.hxh.skymall.uitls.Constance;
import com.hxh.skymall.uitls.KeyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryDao cd;

    public String findAllCategory() {

        if(!CacheOfData.cache.containsKey("category")){
            List<Category> categories = cd.findAllCategory();

            ArrayList<Category> categories1 = new ArrayList<>();

            LinkedList<Category> categories2 = new LinkedList<>();

            categories1.addAll(categories);

            for (Category cate:categories1) {
                if (cate.getParentId().equals("0")){
                    categories2.add(cate);
                }
                for (Category cate2:categories1) {
                    if(cate.getId().equals(cate2.getParentId())){
                        cate.getChildren().add(cate2);
                    }

                }
            }
            String jsonString = JSON.toJSONString(categories2);
            String start ="category.getDataService({\"data\":";
            String end ="})";
            StringBuilder last = new StringBuilder();

            last.append(start);
            last.append(jsonString);
            last.append(end);

            CacheOfData.cache.put("category",last.toString());
        }
            return CacheOfData.cache.get("category");
    }

    public List<Category2> findAllCategory2() {

        if(!CacheOfData.cache2.containsKey("category2")){
            List<Category2> categories = cd.findAllCategory2();

            ArrayList<Category2> categories1 = new ArrayList<>();

            LinkedList<Category2> categories2 = new LinkedList<>();

            categories1.addAll(categories);

            for (Category2 cate:categories1) {
                if (cate.getParentId().equals("0")){
                    categories2.add(cate);
                }
                for (Category2 cate2:categories1) {
                    if(cate.getId().equals(cate2.getParentId())){
                        cate.getChildren().add(cate2);
                    }
                }
            }
            CacheOfData.cache2.put("category2",categories2);
        }
        return CacheOfData.cache2.get("category2");
    }

    public String addCategory(Category2 category2) {

        category2.setId(KeyCreator.getKey());

        try {
            cd.addCategory(category2);

        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }

        return Constance.RESULT_OK;
    }
}

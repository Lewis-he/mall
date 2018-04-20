package com.hxh.skymall.controller;

import com.hxh.skymall.entity.Category2;
import com.hxh.skymall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    public CategoryService cs;

    @RequestMapping(value = "findAllCategory",method = RequestMethod.GET)
    public String findAllCategory(){
        return cs.findAllCategory();
    }

    @RequestMapping(value = "findAllCategory2",method = RequestMethod.GET)
    public List<Category2> findAllCategory2(){
        return cs.findAllCategory2();
    }
    @RequestMapping(value = "addCategory",method = RequestMethod.POST)
    public String addCategory(Category2 category2){

        return cs.addCategory(category2);
    }
}

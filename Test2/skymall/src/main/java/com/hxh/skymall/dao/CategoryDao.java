package com.hxh.skymall.dao;

import com.hxh.skymall.entity.Category;
import com.hxh.skymall.entity.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {
    List<Category> findAllCategory();

    List<Category2> findAllCategory2();

    void addCategory(Category2 category2);
}

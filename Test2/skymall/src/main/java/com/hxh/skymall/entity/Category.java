package com.hxh.skymall.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Category implements Serializable {

    private String id;

    @JSONField(name = "n")
    private String name;

    @JSONField(name = "u")
    private String url="a.html";


    private String parentId;
    @JSONField(name = "i")
    private Set<Category> children = new LinkedHashSet<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Set<Category> getChildren() {
        return children;
    }

    public void setChildren(Set<Category> children) {
        this.children = children;
    }
}

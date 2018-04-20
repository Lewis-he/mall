package com.hxh.skymall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Category2 implements Serializable {

    private String id;

    @JsonProperty("text")
    private String name;

    private String url="a.html";

    private String parentId;

    private Set<Category2> children = new LinkedHashSet<>();

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

    public Set<Category2> getChildren() {
        return children;
    }

    public void setChildren(Set<Category2> children) {
        this.children = children;
    }
}

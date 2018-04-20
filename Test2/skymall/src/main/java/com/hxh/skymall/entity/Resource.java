package com.hxh.skymall.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Resource implements Serializable {
    private int id;
    private String text;
    private Set<Resource> children = new LinkedHashSet<Resource>();
    private String url;
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Resource> getChildren() {
        return children;
    }

    public void setChildren(Set<Resource> children) {
        this.children = children;
    }

}

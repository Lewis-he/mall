package com.hxh.skymall.entity;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private int id;
    private String roleName;
    private String roleId;
    private String password ;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

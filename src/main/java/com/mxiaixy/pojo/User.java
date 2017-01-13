package com.mxiaixy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mxia on 2017/1/12.
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private List<Role> roleList;

    public String  getRoleName(){
        List<String> roleNames = new ArrayList<>();
        for(Role role : roleList){
            roleNames.add(role.getRoleName());
        }
        StringBuffer sb = new StringBuffer();
        for(String viewName:roleNames){
            sb.append(viewName).append("  ");
        }
        return sb.toString();
    }
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

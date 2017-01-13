package com.mxiaixy.pojo;

import java.io.Serializable;

/**
 * Created by Mxia on 2017/1/13.
 */
public class Role implements Serializable {
    private Integer id;
    private String viewName;
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

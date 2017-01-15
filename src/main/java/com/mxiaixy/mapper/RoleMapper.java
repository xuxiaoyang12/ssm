package com.mxiaixy.mapper;

import com.mxiaixy.pojo.Role;

import java.util.List;

/**
 * Created by Mxia on 2017/1/13.
 */
public interface RoleMapper {


    List<Role> findRoleAll();
    List<Role> findRoleByUserId(Integer userid);

}

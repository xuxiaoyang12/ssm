package com.mxiaixy.service.impl;

import com.mxiaixy.mapper.RoleMapper;
import com.mxiaixy.pojo.Role;
import com.mxiaixy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mxia on 2017/1/13.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findRoleAll() {
        return  roleMapper.findRoleAll();

    }


}

package com.mxiaixy.service.impl;

import com.mxiaixy.mapper.UserMapper;
import com.mxiaixy.pojo.User;
import com.mxiaixy.service.UserService;
import com.mxiaixy.untils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mxia on 2017/1/12.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private  UserMapper userMapper;

    @Override
    public List<User> findListUser() {

        List<User> userList = userMapper.findListUser();
        return userList;
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    @Transactional
    public void delUserById(Integer id) {
        //删除关系表
        userMapper.delUserAndRoleBy(id);
        //删除用户表
        userMapper.delUserById(id);
    }

    @Override
    @Transactional//添加事物
    public void save(User user, String[] roleIds) {
        //保存user 获取主键
        userMapper.save(user);
        //判断ids数组是否为空
        if(roleIds==null){

        }else{
            //添加user 和 role的关系
            for(String roleId : roleIds){
                userMapper.saveUserAndRole(user.getId(),Integer.valueOf(roleId));
            }
        }

    }

    @Override
    @Transactional
    public void update(User user, String[] ids) {
        //删除原来的关系表
        userMapper.delUserAndRoleBy(user.getId());
        //添加新关系表
        if(ids==null){

        }else{
            for(String roleId : ids){
                userMapper.saveUserAndRole(user.getId(),Integer.valueOf(roleId));
            }
            //更新用户数据
            userMapper.update(user);
        }

    }

    @Override
    public Page<User> findListUserByPageNo(String pageNo) {
        //获取数据总数量
        int count = userMapper.findUserCount().intValue();
        //获取分页对象
        Page<User> page = new Page<User>(count,Integer.valueOf(pageNo));
        //获取所需页的数据
        List<User> userList = userMapper.findUserByPage(page.getStart(),page.getPageSize());
        //把数据存入分页对象中
        page.setItems(userList);
        return page;
    }

}

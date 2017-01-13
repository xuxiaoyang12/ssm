package com.mxiaixy.service;

import com.mxiaixy.pojo.User;

import java.util.List;

/**
 * Created by Mxia on 2017/1/12.
 */
public interface UserService {


    List<User> findListUser();

    void save(User user);

    User findUserById(Integer id);

    void update(User user);

    void delUserById(Integer id);

    void save(User user, String[] roleIds);

    void update(User user, String[] ids);
}

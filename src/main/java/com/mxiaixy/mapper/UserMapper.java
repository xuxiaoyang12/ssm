package com.mxiaixy.mapper;

import com.mxiaixy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mxia on 2017/1/12.
 */
public interface UserMapper {
    List<User> findListUser();

    void save(User user);

    User findUserById(Integer id);

    void update(User user);

    void delUserById(Integer id);

    void saveUserAndRole(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    void delUserAndRoleBy(Integer id);

    Long findUserCount();

    List<User> findUserByPage(@Param("start") int start,@Param("pageSize") int pageSize);
}

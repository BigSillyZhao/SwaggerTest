package com.bimface.demo.dao;

import com.bimface.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userDao {

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);

    /**
     * 查询某个用户
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     *查询所有的用户
     */
    List<User> findAllUser();
}

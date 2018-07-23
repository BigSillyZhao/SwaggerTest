package com.bimface.demo.service;

import com.bimface.demo.bean.User;
import com.bimface.demo.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService implements userDao {

    @Autowired
    private userDao userdao;

    @Override
    public int insertUser(User user) {
        return userdao.insertUser(user);
    }

    @Override
    public User findByName(String name) {
        return userdao.findByName(name);
    }

    @Override
    public List<User> findAllUser() {
        return userdao.findAllUser();
    }
}

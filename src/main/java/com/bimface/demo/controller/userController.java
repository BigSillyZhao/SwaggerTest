package com.bimface.demo.controller;

import com.bimface.demo.bean.User;
import com.bimface.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class userController {
    //创建线程安全的Map
    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    @Autowired
    private userService userservice;

    @ApiIgnore
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList(){
        // 处理"/users/"的GET请求，用来获取用户列表
        List<User> list = userservice.findAllUser();//new ArrayList<User>(users.values());
        return list;
    }

    @ApiIgnore
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        System.out.println(user.getId());
        userservice.insertUser(user);
        //users.put(user.getId(), user);
        return "创建用户 "+ user.getId()+" 成功！";
    }

   /* @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "更新用户 "+id+" 信息成功！";
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "删除用户 "+id+" 成功！";
    }*/

}

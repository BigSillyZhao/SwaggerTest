package com.bimface.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class taskController {

    @RequestMapping(value = "/",method=RequestMethod.GET)
    public String findAllTask(){

        return null;
    }
}

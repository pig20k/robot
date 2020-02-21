package com.crud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String hello(Map<String,Object> map){
//        return "index";
//    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("name","林茂森");
        return "success";
    }
}

package com.example.myecsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyecsiteController {

    @RequestMapping("")
    public  String init(){
        return "item_list_curry";
    }
}

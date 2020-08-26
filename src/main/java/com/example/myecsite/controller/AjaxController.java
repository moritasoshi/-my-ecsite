package com.example.myecsite.controller;

import com.example.myecsite.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/autocomplete")
    public List<String> autocomplete(String name){
        return itemService.searchItemNames(name);
    }
}

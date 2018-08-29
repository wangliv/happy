package com.wangli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangli.service.HappyService;

@RestController
public class HappyController {
    
    @Autowired
    private HappyService service;

    @RequestMapping("/")
    public String hello(){
        return service.happy();
    }
}

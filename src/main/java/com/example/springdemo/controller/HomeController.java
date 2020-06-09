package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import com.example.springdemo.dao.DynamicAPIDao;
import com.example.springdemo.entity.DynamicAPI;

@RestController
public class HomeController {

    @Autowired
    private DynamicAPIDao dynamicAPIDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<DynamicAPI> getList() {
        return dynamicAPIDao.getList();
    }

    @RequestMapping(value = "/create")
    public int create() {
       return dynamicAPIDao.create();
    }
}
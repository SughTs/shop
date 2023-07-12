package com.example.shop.controller;


import com.example.shop.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController{
    @Autowired
    CollectMapper collectMapper;

    @RequestMapping("/all")
    public String all(HttpServletRequest req){//查询视图中的数据
        req.setAttribute("retList", collectMapper.selectView());
        return "/collect/all";
    }
}

package com.example.shop.controller;

import com.example.shop.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/info")
public class InfoController extends BaseController{
    @Autowired
    InfoMapper infoMapper;
    @RequestMapping("/all")
    public String all(int uid, HttpServletRequest req){
        req.setAttribute("uid", uid);
        req.setAttribute("retList",infoMapper.selectView());
        return "info/all";
    }
    @RequestMapping("/del")
    public String del(int id){
        int uid = infoMapper.selectById(id).uid ;
        infoMapper.deleteById(id) ;
        System.out.println("Info delete!") ;
        return "redirect:/info/all?uid=" + uid ;
    }
}

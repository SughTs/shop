package com.example.shop.controller;


import com.example.shop.mapper.DiscountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/discount")
public class DiscountController extends BaseController{
    @Autowired
    DiscountMapper discountMapper;
    @RequestMapping("/all")
    public String all(HttpServletRequest req){
        //req.setAttribute("uid", uid);
        req.setAttribute("retList",discountMapper.selectView());
        return "discount/all";
    }
    @RequestMapping("/del")
    public String del(int id){
        int uid = discountMapper.selectById(id).id;
        discountMapper.deleteById(id) ;
        System.out.println("discount delete!") ;
        return "redirect:/discount/all?uid"+ uid ;
    }
}

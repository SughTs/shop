package com.example.shop.controller;

import com.example.shop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    OrderMapper orderMapper;
    @RequestMapping("/all")
    public String all(HttpServletRequest req){
        req.setAttribute("retList",orderMapper.selectView());
        return "/order/all";
    }

    @RequestMapping("del")
    public String del(int id){
        int uid = orderMapper.selectById(id).uid;
        orderMapper.deleteById(id);
        System.out.println("Order delete!");
        return "redirect:/order/all?uid=" + uid;
    }

    @RequestMapping("/list")
    public String list(int uid, HttpServletRequest req){
        req.setAttribute("retList",orderMapper.selectList(uid));
        return "/order/list";
    }
}

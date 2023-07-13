package com.example.shop.controller;


import com.example.shop.bean.ControlBean;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.ControlMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/control")
public class ControlController extends BaseController{
    @Autowired
    ControlMapper controlMapper;
    @Autowired
    CategoryMapper categoryMapper;//假报错，这个位置的报错都是假的
    @RequestMapping("/all")
    public String all(HttpServletRequest req){//查询视图中的数据
        req.setAttribute("retList", controlMapper.selectView());
        return "/control/all";
    }
    @RequestMapping("/del")
    public String del(int id){
        //deleteById函数依据主键删除，不用写sql语句
        int uid = controlMapper.selectById(id).id;
        controlMapper.deleteById(id);
        System.out.println("user deleted!");
        return "redirect:/control/all?uid=" + uid;
    }
    @GetMapping("/add")
    public String add(Integer id, HttpServletRequest req){
        //req.setAttribute("cateList",categoryMapper.selectList(null));
        req.setAttribute("bean",id==null?null:controlMapper.selectById(id));
        return "/control/add";
    }
    @PostMapping("/add")
    public String add(ControlBean bean, HttpServletResponse resp){
        if(NotNullUtil.isBlank(bean)){
            return jsAlert("请完善用户信息",resp);
        }
        if(bean.id == null){
            controlMapper.insert(bean);
        }else{
            controlMapper.updateById(bean);
        }
        System.out.print("接收到新用户信息");
        return "redirect:/control/all";
    }
}

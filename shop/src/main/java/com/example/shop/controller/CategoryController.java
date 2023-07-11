package com.example.shop.controller;

import com.example.shop.bean.CategoryBean;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{
    @Autowired//注入
    CategoryMapper categoryMapper;
    @RequestMapping("/list")
    public String list(HttpServletRequest req) {
        req.setAttribute("retList",categoryMapper.selectList(null));
        return "/category/list";
    }
    @RequestMapping("/del")
    public String del(int id){
        categoryMapper.deleteById(id);
        System.out.println("delete!");
        return "redirect:/category/list";
    }
    @GetMapping("/add")
    public String add(Integer id, HttpServletRequest req){
        //id为null，bean为null，否则bean为id对应记录
        req.setAttribute("cateList",categoryMapper.selectList(null));
        req.setAttribute("bean",id==null?null:categoryMapper.selectById(id));
        return "/category/add";//转发位置
    }
    @PostMapping("/add")
    public String add(CategoryBean bean, HttpServletResponse resp){//需要时HttpServletResponse resp才会出现
        if(NotNullUtil.isBlank(bean)){
            return jsAlert("请完善类别信息",resp);
        }
        try {
            if (bean.id == null) {//增加操作
                //bean.ctime = new Date();
                categoryMapper.insert(bean);
            } else {
                categoryMapper.updateById(bean);
            }
        } catch (Exception e){
            return jsAlert("类别名重复！",resp);
        }
        System.out.println("接收到POST！");
        return "redirect:/category/list";
    }
}
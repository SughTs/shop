package com.example.shop.controller;

import com.example.shop.bean.ProductBean;
import com.example.shop.bean.UserBean;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
    @Autowired//注入
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;
    //@Autowired
    //java数组不能在后期添加数据（数组痛点）
    //于是就有了ArrayList
    @RequestMapping("/list")
    public String list(HttpServletRequest req) {
        //ProductBean product = new
        //System.out.println("Here came I, list.");
        //System.out.println(productMapper.selectList(null));
        req.setAttribute("retList",productMapper.selectList(null));
        return "/product/list";
    }
    @RequestMapping("/del")
    public String del(int id){
        //deleteById函数依据主键删除，不用写sql语句
        productMapper.deleteById(id);
        System.out.println("delete!");
        return "redirect:/product/list";
    }
    //@RequestMapping("/deleter")//任何方式都能进来
    //public String deleter(int id){
    //    productMapper.deleteById(id);
    //    return "redirect:/product/list";
    //}
    @GetMapping("/add")
    public String add(Integer id, HttpServletRequest req){
        //id为null，bean为null，否则bean为id对应记录
        req.setAttribute("cateList",categoryMapper.selectList(null));
        req.setAttribute("bean",id==null?null:productMapper.selectById(id));
        return "/product/add";//转发位置
    }
    @PostMapping("/add")
    public String add(ProductBean bean, HttpServletResponse resp){//需要时HttpServletResponse resp才会出现
        if(NotNullUtil.isBlank(bean)){
            //price product logo num全非空
            return jsAlert("请完善商品信息",resp);
        }
        if(bean.id == null) {//增加操作
            bean.ctime = new Date();
            productMapper.insert(bean);//插入数据库，insert是BaseMapper中的方法
        } else {
            productMapper.updateById(bean);//修改操作
        }
        System.out.println("接收到POST！");
        return "redirect:/product/list";
    }
    //注意get与post的问题，请求方式的问题（还有delete、put）
    //get一般是<a></a>，重定向或者浏览器直接写网址访问
    //post可以是<form method="post"> 也可以是通过代码方式访问
    //两种方法都不安全，get最不安全，post稍好

    //怎样做到安全？ 答案是加密。 加密函数一般封装好的。MD5不能解密，可以校验。穷举破解。
}
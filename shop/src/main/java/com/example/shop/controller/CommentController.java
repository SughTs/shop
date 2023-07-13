package com.example.shop.controller;

import com.example.shop.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController{

    @Autowired
    CommentMapper commentMapper;

    @RequestMapping("/all")
    public String all(int uid,HttpServletRequest req){//查询视图中的数据
        req.setAttribute("uid",uid);
        req.setAttribute("retList", commentMapper.selectView());
        return "/comment/all";
    }
/*    @RequestMapping("/del")
    public String del(int id){
        System.out.println("del test");
        //等待完善
        return "redirect:/comment/all?uid="+1;
    }*/
    @RequestMapping("/del")
    public String del(int id){
        int uid = commentMapper.selectById(id).uid;
        commentMapper.deleteById(id);
        System.out.println("comment delete!");
        return "redirect:/comment/all?uid=" + uid;
    }

//

}

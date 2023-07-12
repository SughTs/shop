package com.example.shop.controller;

import com.example.shop.bean.UserBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.UserCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usercart")
public class UserCartController
{
    @Autowired
    UserCartMapper userCartMapper;
    @ResponseBody
    @RequestMapping("index/test")
    public VxResp report(UserBean userBean)//在这接收用户数据
    {
        VxResp testVx=new VxResp();
        //返回内容暂定为购物车完整记录
        testVx.userCart=userCartMapper.selectThis(userBean.id);//后端测试时可以改为常数
        return testVx;
    }
}

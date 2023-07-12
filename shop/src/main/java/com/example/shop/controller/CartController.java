package com.example.shop.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.*;
import com.example.shop.mapper.CartMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController
{
    @Autowired
    CartMapper cartMapper;
    @GetMapping("/add")
    //postmapping网页访问，而getmapping可以不网页访问，不用网页访问的时候用getmapping
    //预留的AIP接口
    public void add()
    {
        //CategoryBean categoryBean,
        //                      HttpServletResponse resp,
        //                      UserBean userBean, ProductBean productBean
        CartBean cartBean=new CartBean(null,1,1,1);
        cartMapper.insert(cartBean);
        System.out.println("成功添加了 cart记录"+cartBean.toString());
    }

    @ResponseBody
    @RequestMapping("index/test")
    public VxResp report(UserBean userBean)//在这接收用户数据
    {
        VxResp testVx=new VxResp();
        //返回内容暂定为购物车完整记录
        testVx.cart=cartMapper.selectThis(userBean.id);
        return testVx;
    }
}

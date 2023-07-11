package com.example.shop.controller;


import com.example.shop.bean.UserBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.UserMapper;
import com.example.shop.util.FileUtil;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;

@Controller//控制器注释
public class UserController {
    //登录
    @Autowired//注入，可以理解成new
    UserMapper userMapper;


    @ResponseBody//把java对象转换成字符串
    @RequestMapping("/login/vx")
    public VxResp login(UserBean bean){//有此人则认证登录，没有此人则依照此username进行注册登录
        VxResp vx = new VxResp();
        if(NotNullUtil.isBlank(bean)){//判断非空
            vx.fail("请完善信息");
            return vx;
        }
        System.out.println(bean.username);
        System.out.println(bean.password);
        bean.status="买家";
        if (userMapper.haveUser(bean.username)!=null) {
            //该账号已经存在，查询密码
            UserBean user = userMapper.getUser(bean);
            if (user == null) {
                System.out.println("login fail！");
                vx.fail("您的密码错误");
            } else {
                System.out.println("success login!");
                //登录成功者的ID返回给小程序
                vx.uid = String.valueOf(user.id);//数字转字符串
            }
        }else{//没有该账号
            bean.user = bean.username;//昵称与用户名相同
            userMapper.insert(bean);//注册到用户表中
            vx.uid = String.valueOf(bean.id);
        }
        return vx;//把对象转换成字符串返回给java
    }
    @RequestMapping("/login")
    public String login(UserBean bean, HttpServletRequest req) throws Exception {//注意抛出异常，扔给了tomcat，项目外壳是tomcat
        //System.out.println(username);
        //System.out.println(password);//测试
        bean.status = "卖家" ;
        UserBean user = userMapper.getUser(bean);
        //if (user==null)
        //    return"/main";
        if(user == null) {
            System.out.println("Wrong username or password");
            return "redirect:/index.html?msg="+ URLEncoder.encode("用户名或密码错误！请尝试重新输入！","utf-8");
        }
        else{
            System.out.println("Successfully login!");//控制台输出
            req.setAttribute("user",user);
            //return "/main";//转发会自动加.html
            return "redirect:/main?uid="+ user.id;//重定向一定显示于地址栏中
        }//小心登录绕过问题
    }

    //@Override
    @RequestMapping("/main")
    public String main(int uid, HttpServletRequest req) {//非主函数,Request转发带参
        //return super.hashCode();
        //System.out.println("输出uid:"+uid);//测试
        //按照ID查询这条记录
        UserBean bean = userMapper.selectById(uid);
        req.setAttribute("user",userMapper.selectById(uid));
        return "/main";
    }
    //转发 return "/address"
    //  打开templates下的网页，这里的网页只能先通过java处理后转发打开
    //  带参不停，req.setAttribute("参数值",值)；
    //  转发是java的行为，地址栏不变
    //
    //  ${}渲染转发带来的数据
    //
    //重定向 return "/address.html"，会刷新网页
    //  打开static下的网页
    //  带参较为简单，为return "redirect:/address.html?参数值=值"，网页使用js获取地址中的参数值
    //  重定向是浏览器的行为，一旦发生重定向，地址栏中的地址会发生改变
    //  对于进入java的地址一般使用重定向进入
    //
    //templates 与 static 文件夹必须存在
    //
    //  使用<a herf='address'>redirect</a>本身就是重定向
    //localhost:8080/upload
    @ResponseBody//该注解可以使return以原始形态输出，底层使json
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        System.out.println("接收文件上传，文件名为"+fileName+" 保存位置N:/lizbit/shop/upload");//注意自行修改
        //save
        FileUtil.createFile("N:/lizbit/shop/upload");
        file.transferTo(new File("N:/lizbit/shop/upload/" + fileName));
        return "/shop/upload/" + fileName ;//字符串返回给网页，直接输出给网页
    }
}

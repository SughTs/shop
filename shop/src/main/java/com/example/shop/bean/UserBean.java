package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;
import org.jsoup.select.Evaluator;

@Data//生成set，get函数
@TableName("tbl_user")
public class UserBean {
    //表里的内容与bean内容相同
    @TableId(type = IdType.AUTO)//id自动递增，要进行设置
    public Integer id;//不要用int，Integer是包装类，可用equals方法可以调用。可以接收null对象，int不可接收。
    @NotNull
    public String username;//varchar类型
    @NotNull
    public String password;
    public String user;
    public String status;
    public String store;
    //访问控制可以写为private，要写set、get函数，麻烦一些
}
//用户表
package com.example.shop.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import lombok.Data;

@Data
@TableName("tbl_info")
public class InfoBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public String info;
    //public TEXT description；
    //public Datetime ctime;
    public Integer uid;
}

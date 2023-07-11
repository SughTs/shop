package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_order")
public class OrderBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public String name;
    public String mobile;
    public String address;
    public Integer total;
    //public Datetime ctime;
    public Integer uid;
}
//订单表
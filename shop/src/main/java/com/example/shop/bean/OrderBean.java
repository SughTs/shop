package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_order")
public class OrderBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    @NotNull
    public String name;
    @NotNull
    public String mobile;
    @NotNull
    public String address;
    @NotNull
    public Integer total;
    public Date ctime;
    @NotNull
    public Integer uid;

    @TableField(exist = false)
    public String username;
    //@TableField(exist = false)
    //public
}
//订单表
package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_cart")
public class CartBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer count;
    public Integer pid;
    public Integer uid;
}
//购物车
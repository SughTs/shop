package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_shopping")
public class ShoppingBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer count;
    public Integer pid;
    public Integer cid;
}
//购物表
package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

@Data
@TableName("tbl_discount")
public class DiscountBean {
    @TableId(type = IdType.AUTO)
    public Integer id;
    @NotNull
    public Integer pid;
    @NotNull
    public Integer discount;

    @TableField(exist = false)
    public String product;
}

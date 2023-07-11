package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.lang.reflect.Type;
@Data
@TableName("tbl_category")
public class CategoryBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    @NotNull
    public String category;
}
//类别表
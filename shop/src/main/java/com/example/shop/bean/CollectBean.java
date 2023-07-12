package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

@Data
@TableName("tbl_collect")
public class CollectBean {

    @TableId(type = IdType.AUTO)
    @NotNull
    public Integer id;
    @NotNull
    public Integer pid;
    @NotNull
    public Integer uid;

    @TableField(exist = false)
    public String username;
    @TableField(exist = false)
    public String product;
}
//收藏表
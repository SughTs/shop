package com.example.shop.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@TableName("tbl_comment")
public class CommentBean {

    @TableId(type = IdType.AUTO)

    @NotNull
    public Integer id;
    @NotNull
    public Integer pid;
    @NotNull
    public Integer uid;
    @NotNull
    public String comment;
    @NotNull
    public Date ctime;

    @TableField(exist = false)
    public String username;
    @TableField(exist = false)
    public String product;
}
//评论表
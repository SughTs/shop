package com.example.shop.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Time;

@Data
@TableName("tbl_comment")
public class CommentBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer pid;
    public Integer uid;
    public String comment;
    public Time ctime;
}
//评论表
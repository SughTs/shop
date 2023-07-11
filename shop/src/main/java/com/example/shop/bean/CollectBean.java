package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_collect")
public class CollectBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer pid;
    public Integer uid;
}
//收藏表
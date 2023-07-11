package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_product")
public class ProductBean {

    @TableId(type = IdType.AUTO)//自增
    public Integer id;//11位数字，100亿可到达极限。要增加，可以试试UUID（32位）、雪花算法。
    @NotNull
    public String product;
    @NotNull
    public Integer price;
    @NotNull
    public String logo;
    public String hot;
    public Date ctime;//java中的data,util中的date
    @NotNull
    public Integer num;//库存
    public Integer uid;
    public Integer cid;
    //以下的两个是视图中的元素，不存在与数据表中，需要排除
    @TableField(exist = false)//此注解表明不存在于数据表中
    public String user;
    @TableField(exist = false)
    public String category;
}
//产品表
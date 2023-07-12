package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userproductcart")
public class UserCartBean
{
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer count;
    public Integer pid;
    public Integer uid;
    public String name;
    public String product;
    public Integer price;
    public String logo;
    public UserCartBean()
    {

    }
    public UserCartBean(Integer id,Integer count,
                        Integer pid,Integer uid,String name,
                        String product,Integer price,String logo)
    {
        this.id=id;
        this.count=count;
        this.pid=pid;
        this.uid=uid;
        this.name=name;
        this.product=product;
        this.price=price;
        this.logo=logo;
    }
}

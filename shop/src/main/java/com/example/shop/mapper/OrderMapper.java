package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.InfoBean;
import com.example.shop.bean.OrderBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<OrderBean> {
    @Select("select * from view_order_user order by id desc")//查询info,user视图
    List<OrderBean> selectView();

    @Select("select * from view_order_user where uid=#{uid} order by ctime desc")//这个语句是SQL语句，注意修改了查询机制
    List<OrderBean> selectList(@Param("uid")int uid);//BaseMapper方法重写，必须传入uid
}

package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<ProductBean> {
    @Select("select * from v2_p where uid=#{uid} order by ctime desc")//这个语句是SQL语句，注意修改了查询机制
    List<ProductBean> selectList(@Param("uid")int uid);//BaseMapper方法重写，必须传入uid

    @Select("select * from v2_p order by id desc")//按照id倒序排序
    List<ProductBean> selectView();

    @Select("select * from v2_p where hot='热卖'")
    List<ProductBean> selectHot();
}

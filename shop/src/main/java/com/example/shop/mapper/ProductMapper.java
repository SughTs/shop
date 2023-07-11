package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<ProductBean> {
    @Select("select * from v2_p order by ctime desc")//这个语句是SQL语句
    List<ProductBean> selectList();//BaseMapper方法重写
}

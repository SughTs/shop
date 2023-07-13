package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.DiscountBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DiscountMapper extends BaseMapper<DiscountBean> {
    @Select("select * from view_discount_product")
    List<DiscountBean> selectView();
}

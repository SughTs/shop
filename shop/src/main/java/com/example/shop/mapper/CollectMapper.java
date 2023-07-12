package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.CollectBean;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper extends BaseMapper<CollectBean> {
    @Select("select * from view_collect_user_product order by id desc")//按照id倒序排序
    List<CollectBean> selectView();
}

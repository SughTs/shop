package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.ControlBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ControlMapper extends BaseMapper<ControlBean> {
    @Select("select * from tbl_user order by id desc")
    List<ControlBean> selectView();
}

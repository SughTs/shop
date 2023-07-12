package com.example.shop.mapper;

import com.example.shop.bean.CartBean;
import com.example.shop.bean.UserCartBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCartMapper
{
    @Select("select * from userproductcart where uid = #{thisId}")
    List<UserCartBean> selectThis(@Param("thisId")Integer thisId);
}

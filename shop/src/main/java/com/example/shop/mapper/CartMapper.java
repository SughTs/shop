package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.CartBean;
import com.example.shop.bean.CategoryBean;
import com.example.shop.bean.ProductBean;
import com.example.shop.bean.UserBean;
import com.example.shop.controller.BaseController;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Repository
public interface CartMapper extends BaseMapper<CartBean>
{
    @Select("select * from tbl_cart where uid = #{thisId}")
    List<CartBean> selectThis(@Param("thisId")Integer thisId);
}

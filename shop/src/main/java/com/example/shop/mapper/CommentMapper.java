package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.CommentBean;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper extends BaseMapper<CommentBean> {
    @Select("select * from view_comment_user_product order by id desc")//按照id倒序排序
    List<CommentBean> selectView();//查询数据表视图view_comment_user_product，这张表由comment,user,product复合


}

package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;//这玩意
import com.example.shop.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<UserBean> {
    //接口：方法抽象
    @Select("select * from tbl_user where username=#{username} and password=#{password} and status=#{status}")//MyBatis注解,注意取值操作的方法#{}
    //如果形参未包装类，需要加入@Param注解
    UserBean getUser(UserBean bean);//编译器有时会更改形参的名字，需要用@Param注释来固定

    //@Select("select * from tbl_user where username=#{username} and password=#{password} and status='买家'")
    //UserBean getBuyer(UserBean bean);
    @Select("select * from tbl_user where username=${username}")
    UserBean haveUser(@Param("username")String username);
}

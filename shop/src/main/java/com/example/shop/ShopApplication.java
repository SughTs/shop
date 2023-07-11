package com.example.shop;//修改包名

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

@Configuration//配置注解，表明类中有配置代码
@SpringBootApplication//SpringBoot必须有的注解，可以把类标识为SpringBoot启动类
@MapperScan("com.example.shop.mapper")//扫描注解

//bean 对应数据表
//controller 写SPB代码
//mapper SQL
//util 工具包

public class ShopApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
        //项目只有在启动成功后才会出现以下提示！OVO
        System.out.println("(♥◠‿◠)ﾉﾞ  后台启动成功   ლ(´ڡ`ლ)ﾞ \n" );
    }



//    @Bean//分页查询配置
//    public MybatisPlusInterceptor page() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        return interceptor;
//    }

    @Override//配置虚拟路径，在上传图片成功后调用，可以将未显示的图片显示出来
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/shop/**").addResourceLocations("file:N:/lizbit/shop/");
    }

}

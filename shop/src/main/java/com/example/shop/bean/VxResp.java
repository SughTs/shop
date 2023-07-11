package com.example.shop.bean;

import java.util.List;

public class VxResp {//给小程序返回的数据都在这里定义
    public int code = 1;//响应码，1成功0失败，初始值赋值为1，默认成功
    public String msg = "";//默认无内容

    public void fail(String msg){//失败函数
        this.code=0;//fail
        this.msg = msg;
    }
    public String uid = "" ;//给小程序的uid
    public List<ProductBean> hots;//数组
}

const util = require('../../utils/util')

Page({//系统函数
  data:{//页面全局变量
      username:'',//js中大括号表示对象，初始为空字符串
      password:'',
  },
  onLoad(options){//页面主函数
    if(wx.getStorageSync('uid')){//打开时去取得uid，直接进入index
      wx.switchTab({
        url: '../index/index',
      })
    }
  },
  onInput(e){//e指代当前事件
    //console.log(e.detail.value)//获取正在输入的内容
    //console.log(e.currentTarget.dataset.name)//data-name -> dataset.name，获取标签的data-name
    //this.data.e.currentTarget.dataset.name//this.data指Page中的data，写法与下面等价
    this.data[e.currentTarget.dataset.name] = e.detail.value
  },
  submit(){
    console.log(this.data.username)
    console.log(this.data.password)
    //util.alert(XXXX)也可以
    util.http('http://localhost:8080/login/vx', 
    this.data,resp=>{
      if(resp.code == 1){
        wx.setStorageSync('uid', resp.uid)//把此人uid存入小程序软件内部存储
        wx.switchTab({//打开网页
          url: '../index/index',
        })
      }
      else{
        util.alert(resp.msg)
      }
    })//简单写法，将小程序数据提交给java
  },
  holloer(e){//测试函数
    
  },
})
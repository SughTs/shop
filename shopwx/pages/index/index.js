const util = require('../../utils/util')
const app = getApp()//导入app.js
Page({
  data:{
    api: app.globalData.api,
    hots:[],
  },
  onLoad(){
    util.http('http://localhost:8080/product/index/vx',resp=>{
      util.alert(resp)
      this.data.hots = resp.hots
      this.setData(this.data)
    })
  } 
})

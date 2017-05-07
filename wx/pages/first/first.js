Page({
  data:{
    text: "这个是内容",
    text1:"a",
    text2:"b",
    btnText:"这是按钮的内容",
    flag:true,
    news:['aaa','bbb','ccc']
  },
  onLoad:function(options){
    // 生命周期函数--监听页面加载
   
  },
  onReady:function(){
    // 生命周期函数--监听页面初次渲染完成
   
  },
  onShow:function(){
    // 生命周期函数--监听页面显示
    
  },
  onHide:function(){
    // 生命周期函数--监听页面隐藏
   
  },
  onUnload:function(){
    // 生命周期函数--监听页面卸载
    
  },
  onPullDownRefresh: function() {
    // 页面相关事件处理函数--监听用户下拉动作
    
  },
  onReachBottom: function() {
    // 页面上拉触底事件的处理函数
    
  },
  onShareAppMessage: function() {
    // 用户点击右上角分享
    return {
      title: 'title', // 分享标题
      desc: 'desc', // 分享描述
      path: 'path' // 分享路径
    }
  },
  btnClick:function(){
      console.log("按钮点击了");
      //this.setData({text:"这是一条新的内容"});
      var isflag = this.data.flag;
      var newData = this.data.news;
      newData.shift();
      this.setData({flag:!isflag,news:newData});
  },
  bindView1:function(event){
    console.log("v1点击了");
    console.log(event);
  },
  bindView2:function(event){
    console.log("v2点击了");
    console.log(event);
  },
  bindView3:function(event){
     console.log("v3点击了");
     console.log(event);
  },
})
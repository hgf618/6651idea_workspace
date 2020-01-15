<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/30 0030
  Time: 上午 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>upload模块快速使用</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>

<button type="button" class="layui-btn" id="test1">
    <i class="layui-icon">&#xe67c;</i>上传图片
</button>
<div lay-filter="demo" class="layui-progress layui-progress-big" lay-showPercent="yes">
    <div class="layui-progress-bar layui-bg-blue" lay-percent="0%"></div>
</div>

<script src="layui/layui.js"></script>
<script>

    layui.use(['upload', 'element'], function(){
        var upload = layui.upload;
        var element = layui.element;
        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: 'upload3' //上传接口
            ,field : 'mf' //后台接收参数名
             , progress: function(n){
                var percent = Math.floor(n) + '%' //获取进度百分比
                element.progress('demo', percent); //可配合 layui 进度条元素使用
            }
            ,auto:true
             ,accept: 'file' //允许上传的文件类型
            //,size: 1024*2 //限定大小
            ,done: function(res){
                //上传完毕回调
                //假设code=0代表上传成功
                if(res.code == 0){
                    //do something （比如将res返回的图片链接保存到表单的隐藏域）
                    alert("上传完成");
                }
            }
            ,error: function(){
                //请求异常回调
                alert("上传失败");
            }
        });
    });

    /*
    var upId=122;
    layui.use(['upload','form', 'element'], function(){
        var element = layui.element;
        var upload = layui.upload;
        var $ = layui.jquery;  //为了方便, 在这里引入了jquery
        var uploadInst = upload.render({
            elem: '#test1', //绑定元素,这个是html中上传控件的id
            url: 'upload3', //上传接口url
            progress: function(n){
                var percent = Math.floor(n) + '%' //获取进度百分比
                element.progress('demo', percent); //可配合 layui 进度条元素使用

            },
            accept: 'file', //允许上传的文件类型
            //exts: 'jpg|pdf',  //此处可以限制上传文件的类型, 用|分隔
            multiple:true,
            data:{type:'1',id:upId},  //此处是上传文件时携带的一些参数, 可以使用常数或变量, 如果使用动态值, 需要layui 2.2.6 及以上,详见官方问答NG
            before: function(obj){
                layer.load(); //上传前loading
            },
            field:"file", //默认文件域是file,也可以自己定义,这个和后台struts中获取文件名有关
            allDone: function(obj){  //全部提交完后回调
                layer.closeAll('loading'); //在完成全部提交后关闭loading
                //在所有文件提交完后可以在这里处理一些事务

            },
            done: function(res){  //每个文件提交一次触发一次。
                //上传完毕回调, 每次上传一个文件后都会执行, res是该次上传后台返回的数据
                //alert(JSON.stringify(res.msg));
            },
            error: function(){
                //请求异常回调
                //layer.closeAll('loading'); //关闭loading
            }
        });

    });
*/

</script>
</body>
</html>

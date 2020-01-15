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

<script src="layui/layui.js"></script>
<script>
    /*
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: 'UploadAction' //上传接口
            ,done: function(res){
                //上传完毕回调
                alert("上传完成");
            }
            ,error: function(){
                //请求异常回调
                alert("上传失败");
            }
        });
    });*/

    var upId=122;
    layui.use(['upload','form', 'layedit', 'laydate'], function(){
        var upload = layui.upload;
        var $ = layui.jquery;  //为了方便, 在这里引入了jquery
        var uploadInst = upload.render({
            elem: '#test1', //绑定元素,这个是html中上传控件的id
            url: 'upload2', //上传接口url
            exts: 'jpg|pdf',  //此处可以限制上传文件的类型, 用|分隔
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
                alert(JSON.stringify(res));
            },
            error: function(){
                //请求异常回调
                //layer.closeAll('loading'); //关闭loading
            }
        });

    });


</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/4
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<style>
    div{
        border: 1px solid red;
        background-color: red;
        width:100px;
        font-size: 30px;
        font-family: Utsaah;
        margin: 10px;
        float: left;
    }
    .zgh{
        color: darkmagenta;
    }
    .zxl{
        color: white;
    }
    .hide{
        display: none;
    }
    .bg1{
        background-color: chartreuse;
        width: 150px;
    }
</style>
<body>

<div class="hide">
<div>周欣彤</div>
<div class="zgh">周贵华</div>
<div class="zxl">周小丽</div>
<div class="">彤欣</div>
<div class="hide">雷yun</div>
<div class="">将老师</div>
<div class="">肖老师</div>
<div class="bg1">小红老师</div>
<br />
<table border="1">
    <th>
        <td>星期一</td>
        <td>星期二</td>
        <td>星期三</td>
        <td>星期四</td>
        <td>星期⑤</td>
        <td>星期六</td>

    </th>
    <tr>
        <td>语文</td>
    </tr>
</table>
</div>
<div ></div>

    <h3>传统文件上传</h3>
<form action="user/fileupload1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br/>
    <input type="submit" value="提交">
</form>

<h3>Springmvc文件上传</h3>
<form action="user/fileupload3" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br/>
    <input type="submit" value="提交">
</form>

<h3>跨服务器文件上传</h3>
<form action="user/fileupload4" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>

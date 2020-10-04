<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/3
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                console.log("click");
                //alert("hello ajax1")
                $.ajax({
                    url:"user/testAjax",
                    contentType:'application/json;charset=UTF-8', // charset=UTF-8
                    data: '{"uname":"西游记","age":21,"date":"2020-11-11"}',//JSON.stringify('{"uname":"leiy","age":21}'),
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // data 服务器响应的json数据，进行解析
                        console.log(data);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="user/testString">testToString</a> <br />
<a href="user/testModelAndView">testModelAndView</a><br/>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a> <br />
<input type="submit" id="btn" value="发送ajax请求" />
</body>
</html>

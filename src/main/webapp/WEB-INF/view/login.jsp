<%--
  Created by IntelliJ IDEA.
  User: syiti
  Date: 2018/3/9
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script type="text/javascript" src="/js/jquery-1.9.1.js"></script>

<script type="text/javascript" src="/js/jquery-1.9.1.js"></script>
<!-- 表单验证 -->
<script type="text/javascript" src="/js/jquery-validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery-validate/messages_zh.min.js"></script>
<script type="text/javascript" src="/js/jquery-validate/jquery.validate.rules.js"></script>

</head>
<body>
<form class="cmxform" id="signupForm" method="post" action="">
    <fieldset style="width: 20%">
        <legend >登录验证</legend>

        <p>
            <label for="username">用户名</label>
            <input id="username" name="username" type="text">
            <span style="color:Red;font-size:10px;"></span>
        </p>
        <p>
            <label for="password">密码</label>
            <input id="password" name="password" type="password">
            <span style="color:Red;font-size:10px;"></span>
        </p>
        <p>
            <input class="submit" type="submit" value="提交">
        </p>
    </fieldset>
</form>


<script>
    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#signupForm").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 2
                },
                password: {
                    required: true,
                    minlength: 5
                },
            },
            messages: {
                firstname: "请输入您的名字",
                lastname: "请输入您的姓氏",
                username: {
                    required: "请输入用户名",
                    minlength: "用户名必需由两个字母组成"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码长度不能小于 5 个字母"
                },
                confirm_password: {
                    required: "请输入密码",
                    minlength: "密码长度不能小于 5 个字母",
                    equalTo: "两次密码输入不一致"
                },
                email: "请输入一个正确的邮箱",
                agree: "请接受我们的声明",
                topic: "请选择两个主题"
            },
            /*错误提示位置*/
            errorPlacement:function(error,element){
                error.appendTo(element.siblings("span"));
            },
            submitHandler: function() {
                if($('#username').val()==null){
                    alert('用户名不能为空')
                    return false;
                }
                if($('#password').val()==null){
                    alert('密码不能为空')
                    return false;
                }

                //登录
                $.ajax({
                    type: "post",
                    url: "/user/loginCheck",
                    dataType: "json",
                    contentType:'application/json;charset=UTF-8',//关键是要加上这行
                    traditional:true,//这使json格式的字符不会被转码
                    data: JSON.stringify({ 'username': $('#username').val(), 'password': $('#password').val() }),
                    timeout: 20000,
                    success : function (data) {
                        if(data){
                            alert("登录成功！");
                            window.location.href="/user/index";
                        }else {
                            alert("登录失败！");
                        }

                    },
                    error : function (data){
                        alert(data.responseText);
                    }
                });
            }
        });
    });
</script>
</body>
</html>


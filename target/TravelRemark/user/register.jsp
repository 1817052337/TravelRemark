<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>旅途点评注册</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
          content="Slide Login Form template Responsive, Login form web template, Flat Pricing tables, Flat Drop downs Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>


    <!-- Custom Theme files -->
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- //Custom Theme files -->

    <!-- web font -->
    <link href="<%=request.getContextPath()%>/fonts.googleapis.com/css?family=Hind:300,400,500,600,700"
          rel="stylesheet">
    <!-- //web font -->
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

    <script>


        //校验用户名
        //单词字符，长度8到20位
        function checkUsername() {

            //1.获取用户名值
            var user_name = $("#user_name").val();
            //2.定义正则
            var reg_username = /[a-zA-Z]{6,12}/;

            //3.判断，给出提示信息
            var flag = reg_username.test(user_name);

            if (flag) {
                //用户名合法
                $("#divuser_name").css("border", "1px solid blue");
            } else {
                //用户名非法,加一个红色边框
                $("#divuser_name").css("border", "1px solid red");
            }

            $.post("<%=request.getContextPath() %>/user/userservlet.do?method=regist_user_name", {user_name: $("#user_name").val()}, function (data) {
                if (data.flag == false) {
                    alert(data.errorMsg)
                }
            });
            return flag;
        }

        //校验密码
        function checkPassword() {
            //1.获取密码值
            var user_password = $("#user_password").val();
            //2.定义正则
            var reg_password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$/;

            //3.判断，给出提示信息
            var flag = reg_password.test(user_password);
            if (flag) {
                //密码合法
                $("#divuser_password").css("border", "1px solid blue");
            } else {
                //密码非法,加一个红色边框
                $("#divuser_password").css("border", "1px solid red");
            }

            return flag;
        }

        //确定密码
        function checkPassword_Q() {
            //校验密码
            var user_password = $("#user_password").val();
            //确定密码
            var user_newpassword = $("#user_newpassword").val();

            if (user_password == user_newpassword) {
                //相同
                $("#divuser_newpassword").css("border", "1px solid blue");
            } else {
                //不同
                $("#divuser_newpassword").css("border", "1px solid red");
            }
            return user_password == user_newpassword;

        }

        //校验邮箱
        function checkEmail() {
            //1.获取邮箱
            var user_email = $("#user_email").val();
            //2.定义正则		itcast@163.com
            var reg_email = /^\w[1-9]\d{7,10}@qq\.com$/;

            //3.判断
            var flag = reg_email.test(user_email);
            if (flag) {
                $("#divuser_email").css("border", "1px solid blue");
            } else {
                $("#divuser_email").css("border", "1px solid red");
            }

            return flag;
        }

        $(function () {

            //当表单提交时，调用所有的校验方法
            $("#que_but").click(function () {
               
                //1.发送数据到服务器
             
                if (checkUsername() ==true && checkPassword()==true && checkPassword_Q() ==true&& checkEmail()==true) {
                    //校验通过,发送ajax请求，提交表单的数据   username=zhangsan&password=123
                   

                    $.post("<%=request.getContextPath() %>/user/userservlet.do?method=regist",{
                        user_name: $("#user_name").val(),
                        user_password: $("#user_password").val(),
                        user_email: $("#user_email").val(),
                        user_code: $("#user_code").val()
                    },function (data) {
                        if (data.flag == false) {
                            //注册失败,弹出提示框
                            alert(data.errorMsg);
                            //刷新图片
                            $("#yan_image").attr("src", "<%=request.getContextPath() %>/user/checkCode.do?" + new Date().getTime())
                        }else {
                            //跳珠到等待页面
                            location.href = "<%=request.getContextPath() %>/user/register_ok.jsp"
                        }
                    })

                }
                //2.不让页面跳转
                return false;
                //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
            });

            //当某一个组件失去焦点是，调用对应的校验方法
            $("#user_name").blur(checkUsername);
            $("#user_password").blur(checkPassword);
            $("#user_newpassword").blur(checkPassword_Q);
            $("#user_email").blur(checkEmail);

        });
    </script>
</head>
<body>

<!-- main -->
<div class="w3layouts-main">
    <div class="bg-layer">
        <h1>注册</h1>
        <div class="header-main">
            <div class="main-icon">
                <span class="fa fa-eercast"></span>
            </div>
            <div class="header-left-bottom">
                <form action="" method="post" id="form_que">
                    <div class="icon1" id="divuser_name">
                        <span class="fa fa-user"></span>
                        <input type="username" id="user_name" name="user_name" placeholder="请输入用户名" value=""/>
                    </div>

                    <div class="icon1" id="divuser_password">
                        <span class="fa fa-lock"></span>
                        <input type="password" id="user_password" name="user_password" placeholder="请输入密码" value=""
                               required="required"/>
                        <span id="span_password"></span>
                    </div>
                    <div class="icon1" id="divuser_newpassword">
                        <span class="fa fa-lock"></span>
                        <input type="password" id="user_newpassword" name="user_newpassword" placeholder="再输一次" value="" required="required"/>
                    </div>

                    <div class="icon1" id="divuser_email">
                        <span class="fa fa-envelope"></span>
                        <input type="email" name="user_email" id="user_email" placeholder="请输入邮箱" value=""/>
                    </div>

                    <div class="icon1" id="divuser_code">
                        <input type="username" id="user_code" name="user_code" placeholder="输入验证码" required=""/>
                    </div>
                    <div style="text-align: center">
                        <img src="<%=request.getContextPath() %>/user/checkCode.do" height="32px" alt="yan_image"
                             onclick="changeCheckCode(this)" id="">
                        <script type="text/javascript">
                            //图片点击事件
                            function changeCheckCode(img) {
                                img.src = "<%=request.getContextPath() %>/user/checkCode.do?" + new Date().getTime();
                            }
                        </script>
                    </div>
                    <div class="bottom">
                        <button class="btn" id="que_but">注册</button>
                    </div>
                    <div class="links">
                        <p><a href="index.html">返回登录</a></p>
                        <p class="right"><a href="#">跳过</a></p>
                        <div class="clear"></div>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <!-- //copyright -->
</div>
</div>
<!-- //main -->

</body>
</html>
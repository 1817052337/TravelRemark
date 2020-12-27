<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
<title>Slide Login Form Flat Responsive Widget Template :: w3layouts</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Slide Login Form template Responsive, Login form web template, Flat Pricing tables, Flat Drop downs Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

	 <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

	<!-- Custom Theme files -->
	<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->

	<!-- web font -->
	<link href="<%=request.getContextPath()%>/fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
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

		   $(function () {
				
			   //当表单提交时，调用所有的校验方法
			   $("#que_but").click(function () {

				   //1.发送数据到服务器

				   if (checkUsername() && checkPassword()) {
					   //校验通过,发送ajax请求，提交表单的数据   username=zhangsan&password=123

					   $.post("<%=request.getContextPath() %>/user/userservlet.do?method=login",{
						   user_name: $("#user_name").val(),
						   user_password: $("#user_password").val(),
					   },function (data) {
						   if (data.flag == false) {
							   //注册失败,弹出提示框
							   alert(data.errorMsg);

						   }else {
						   	location.href = "<%=request.getContextPath() %>/index.jsp"
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

		   });
	   </script>
</head>
<body>

<!-- main -->
<div class="w3layouts-main"> 
	<div class="bg-layer">
		<h1>旅游点评登录</h1>
		<div class="header-main">
			<div class="main-icon">
				<span class="fa fa-eercast"></span>
			</div>
			<div class="header-left-bottom">
				<form  method="post" action="" >
					<div class="icon1">
						<span class="fa fa-user"></span>
						<input type="username"  name="user_name" id="user_name" placeholder="账号" value="zhangsan"/>
					</div>
					<div class="icon1">
						<span class="fa fa-lock"></span>
						<input type="password" name="user_password" id="user_password" placeholder="密码" value="t7z3r8h5"/>
					</div>
					<div class="bottom">
						<button class="btn" id="que_but">登录</button>
					</div>
					<div class="links">
						<p><a href="<%=request.getContextPath() %>/manage/login.do?method=wangjimima">忘记密码</a></p>
						<p class="right"><a href="<%=request.getContextPath() %>/user/register.jsp">注册</a></p>
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
</html>
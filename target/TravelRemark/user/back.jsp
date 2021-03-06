<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-8"%>
<!DOCTYPE html>
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
       <script type="text/javascript">
    				function checkPassword(){
        //获取密码输入
        var uPass = document.getElementById("password").value.trim();
        var span = document.getElementById("span_password");
        //对密码输入进行校验
        if(uPass.length == 0){
            span.innerHTML = "<font color='red' size='2'><br />不能为空</font>";
            return false;
        }else if(uPass.length < 6 && uPass.length > 0){
            span.innerHTML = "<font color='red' size='2'><br />密码太短</font>";
            return false;
        }
        else if (uPass.length >14){
            span.innerHTML = "<font color='red' size='2'><br />密码太长</font>";
            return false;
        }
        else{
            span.innerHTML = "<font color='green' size='2'><br />密码可用</font>";
            return true;
        }
    }
 
    /*
     确认密码校验
     * */
    function checkRePassword(){
        //获取密码输入
        var uPass = document.getElementById("password").value.trim();
        //获取确认密码输入
        var uRePass = document.getElementById("repsword").value.trim();
        var span = document.getElementById("span_repassword");
        //对密码输入进行校验
        if(uPass != uRePass){
            span.innerHTML = "<font color='red' size='2'>X,两次密码不一致</font>";
            return false;
        }else{
            span.innerHTML = "";
            return true;
        }
    }
    </script>

	<!-- Custom Theme files -->
	<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->

	<!-- web font -->
	<link href="<%=request.getContextPath()%>/fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
	<!-- //web font -->

</head>
<body>

<!-- main -->
<div class="w3layouts-main"> 
	<div class="bg-layer">
		<h1>找回密码</h1>
		<div class="header-main">
			<div class="main-icon">
				<span class="fa fa-eercast"></span>
			</div>
			<div class="header-left-bottom">
				<form action="<%=request.getContextPath() %>/manage/login.do?method=zhaohui" method="post">
					<div class="icon1">
						<span class="fa fa-envelope"></span>
						<input type="email" id="user_email" placeholder="请输入邮箱" value=""/>
					</div>
					
					
					<div class="icon1">
						<span class="fa fa-lock"></span>
						<input type="password" name="user_password" placeholder="新密码"  required="required" value="" onfocus="showTips('span_password','长度不能小于6且不能大于14')" onblur="checkPassword()" onkeyup="checkPassword()"/>
						<span id="span_password"></span>
					</div>
					<div class="icon1">
						<span class="fa fa-lock"></span>
						<input type="password" name="user_newpassword" placeholder="确认密码"  required="required" value="" onblur="checkRePassword()" onkeyup="checkRePassword()"/>
						<span id="span_repassword"></span>
					</div>
					<div>
						<input type="button" value="发送验证码" />
					</div>
					<div class="icon1">
						<span class="fa fa-envelope-open"></span>
						<span><a href="https://www.baidu.com/?tn=78000241_9_hao_pg"></a></span>
						<input type="username" id="user_code" placeholder="输入验证码" value=""/>
					</div>
					
					<div class="bottom">
						<button class="btn">登录</button>
					</div>
					<div class="links">
						<p><a href="<%=request.getContextPath() %>/manage/login.do?method=fanhui">返回登录</a></p>
						<p class="right"><a href="<%=request.getContextPath() %>/manage/login.do?method=zhuce">注册</a></p>
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
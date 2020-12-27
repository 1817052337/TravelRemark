<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Plugins for this template -->
<!-- Plugins for this template -->
<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="wpoceans">

    <!-- Page Title -->
    <title>Varaus</title>

    <!-- Icon fonts -->
    <link href="<%=request.getContextPath()%>/assets/css/themify-icons.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/flaticon.css" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Plugins for this template -->
    <link href="<%=request.getContextPath()%>/assets/css/animate.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/owl.carousel.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/owl.theme.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/slick.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/slick-theme.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/odometer-theme-default.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/owl.transitions.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/jquery.fancybox.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/magnific-popup.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/nice-select.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap-datepicker.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="home">
<!--最顶上蓝色头区域  地区选择功能-->
<div class="topbar">
    <div class="container-fluid">
        <div class="row">
            <div class="col col-md-6 col-sm-7 col-12">
                <!--地区选择-->
                <div class="contact-intro">
                    <ul>
                        <li><i class="fi ti-location-pin"></i>保定</li>
                        <li><i class="fi flaticon-email"></i> 111.163.cm</li>
                    </ul>
                </div>
                <!--地区选择-->
            </div>
            <div class="col col-md-6 col-sm-5 col-12">
                <!--右侧分享 不确定按钮 查看详情（可放置个人功能）-->
                <div class="contact-info">
                    <ul>
                        <li>
                            <a href="#"><i class="ti-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="ti-twitter-alt"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="ti-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="ti-google"></i></a>
                        </li>
                        <li>
                            <a class="theme-btn-s2" href="#">查看详情 </a>
                        </li>
                    </ul>
                </div>
                <!--右侧分享 不确定按钮-->
            </div>
        </div>
    </div>
</div>
<!--最顶上蓝色头区域  地区选择功能-->
<!--第二行 头区域 logo 以及 各个页面跳转 搜索功能-->
<div class="page-wrapper">
    <!--第二行 头区域 logo 以及 各个页面跳转 搜索功能-->
    <header id="header" class="site-header header-style-2">
        <nav class="navigation navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <!--LOGO-->
                    <a class="navbar-brand" href="index.html"><img src="<%=request.getContextPath()%>/assets/images/logo-2.png" alt=""></a>
                    <!--LOGO-->
                </div>
                <!--各个跳转页面-->
                <div id="navbar" class="navbar-collapse collapse navigation-holder">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">主页 </a>
                        </li>
                        <li>
                            <a href="#">发布 </a>
                        </li>
                        <li>
                            <a href="#">帮助</a>
                        </li>
                    </ul>
                </div>
                <!--各个跳转页面-->
                <!--最右侧功能区域-->
                <div class="cart-search-contact">
                    <div class="header-search-form-wrapper">
                        <button class="search-toggle-btn"><i class="ti-search"></i></button>
                        <div class="header-search-form">
                            <!--搜索功能表单-->
                            <form action="#">
                                <div>
                                    <input type="text" class="form-control" placeholder="请输入搜索地区...">
                                    <button type="submit"><i class="fi flaticon-search"></i></button>
                                </div>
                            </form>
                            <!--搜索功能表单-->
                        </div>
                    </div>
                </div>
                <!--最右侧功能区域-->
            </div>
        </nav>
    </header>
    <!--第二行 头区域 logo 以及 各个页面跳转 搜索功能-->



    <!-- start page-title -->
    <section class="page-title">
        <div class="container">
            <div class="row">
                <div class="col col-xs-12">
                    <h2>发布成功</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="<%=request.getContextPath()%>/homeServlet">返回首页</a>
                        </li>
                        <li>
                            <a href="details.html">查看详情</a>
                        </li>
                    </ol>
                </div>
            </div>
            <!-- end row -->
        </div>
        <!-- end container -->
    </section>
    <!-- end page-title -->


    <!-- All JavaScript files
================================================== -->
    <script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/owl.carousel.min.js"></script>

    <!-- Plugins for this template -->
    <script src="<%=request.getContextPath()%>/assets/js/jquery-plugin-collection.js"></script>

    <script src="<%=request.getContextPath()%>/assets/js/bootstrap-datepicker.min.js"></script>

    <!-- Custom script for this template -->
    <script src="<%=request.getContextPath()%>/assets/js/script.js"></script>
</div>
</body>
</html>
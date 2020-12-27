<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="wpoceans">

    <!-- Page Title -->
    <title>个人中心</title>

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

    <!-- 引入Bootstrap的样式表 -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css">

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
                            <a href="index.html"  target="_blank"   >主页 </a>
                        </li>
                        <li>
                            <a href="release.html#Contact" target="_blank" >发布 </a>
                        </li>
                        <li>
                            <a href="search.html#selectdw1" target="_blank" >搜索</a>
                        </li>
                    </ul>
                    <!--搜索框-->
                    <div class="col-sm-6" style="padding-top: 30px;">
                        <div class="input-group">
                            <input type="text" class="form-control input-lg"><span class="input-group-addon btn btn-primary"><i class="ti-search"></i></span>
                        </div>
                    </div>
                    <!--搜索框-->
                </div>
            </div>
        </nav>
    </header>
    <!--第二行 头区域 logo 以及 各个页面跳转 搜索功能-->
</div>


<!-- 大图部分 删则空白地方较大 -->
<section class="page-title">
    <div class="container">
        <div class="row">
            <div class="col col-xs-12">
                <h2>Blog</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html"  target="_blank">Home</a>
                    </li>
                    <li>Blog</li>
                </ol>
            </div>
        </div>
        <!-- end row -->
    </div>
    <!-- end container -->
</section>
<!-- 大图部分 -->

<!-- start wpo-blog-pg-section -->
<section class="wpo-blog-pg-section blog-pg-left-sidebar section-padding">
    <div class="container">
        <div class="row">
            <div class="col col-md-8 col-md-push-4"style="background-color: #F5FBF9; width: 700px; height: 840px;text-align: center;">
                <!--选项卡切换-->
                <div class="wpo-blog-content">
                    <ul class="nav nav-tabs">
                        <!--第一个选项卡-->
                        <li class="active"><a href="#tab1" data-toggle="tab">评论</a></li>
                        <!--第二-->
                        <li><a href="#tab2" data-toggle="tab">图片</a></li>
                        <!--第三-->
                        <li ><a href="#tab3" data-toggle="tab">签到</a></li>
                        <!--第四-->
                        <li><a href="#tab4" data-toggle="tab">帖子</a></li>
                    </ul>
                    <div class="tab-content">
                        <!--第一个选项卡内容-->
                        <div class="active tab-pane" id="tab1">
                            <p>哪家店特别让你满意？那家店让你深恶痛绝？写封评价记录一下，顺便还能告诉更多人知道哦！
                                <span class="micro-btn-ash">
											<a class="btn-txt" href="http://www.dianping.com/addreview" targe="_blank" onclick="pageTracker._trackPageview('dp_mypage_addreview');">
												写评价
											</a>
										</span>
                            </p>
                        </div>
                        <!--第二-->
                        <div class="tab-pane" id="tab2"><img src="<%=request.getContextPath()%>/assets/images/blog-details/comments-author/img-1.jpg"></div>
                        <!--第三-->
                        <div class="tab-pane" id="tab3"><img src="<%=request.getContextPath()%>/assets/images/blog-details/comments-author/img-2.jpg"></div>
                        <!--第四-->
                        <div class="tab-pane" id="tab4"><img src="<%=request.getContextPath()%>/assets/images/blog/img-4.jpg"></div>
                    </div>
                </div>
                <!--选项卡切换-->
            </div>

            <div class="col col-md-4 col-md-pull-8" style="">
                <div class="wpo-blog-sidebar">
                    <div class="widget profile-widget">


                        <div class="profile-img">
                            <!--头像-->
                            <img src="<%=request.getContextPath()%>/assets/images/blog/profile.png" alt="">
                            <!--用户名-->
                            <h2>小车的宝贝有内涵i</h2>
                            <h4>参考城市：保定</h4>
                            <p>欢迎来到旅游点评，在家就可以环游世界，我们与你同在！</p>
                        </div>


                        <div class="modebox person-info">
                            <div class="con">
                                <!--关注点赞-->
                                <div class="user_atten">
                                    <ul>
                                        <li style="display: inline;"><span>关注</span></li>
                                        <li style="display: inline;"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;粉丝&nbsp;&nbsp;</span></li>
                                        <li style="display: inline;"><span>&nbsp;&nbsp;获赞</span></li>
                                    </ul>
                                    <ul>
                                        <li style="display: inline;"><span>66</span></li>
                                        <li style="display: inline;"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;83 &nbsp;</span></li>
                                        <li style="display: inline;"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;98</span></li>
                                    </ul>
                                    <ul>
                                        <li style="display: inline;"><a href="<%=request.getContextPath()%>/travelremark/userSetServlet.do?method=findByIdUser">编辑个人资料</a></li>
                                    </ul>
                                </div>
                                <!--注册时间-->
                                <div class="user-time">
                                    <p><span class="col-exp">注册时间：</span>2019-03-30</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--搜索框-->
                    <div class="widget search-widget">
                        <form>
                            <div>
                                <input type="text" class="form-control" placeholder="输入关键字...">
                                <button type="submit"><i class="ti-search"></i></button>
                            </div>
                        </form>
                    </div>
                    <!--类别-->
                    <div class="widget category-widget">
                        <h3>类别</h3>
                        <ul>
                            <li>
                                <a href="#"  target="_blank">酒店管理<span>(8)</span></a>
                            </li>
                            <li>
                                <a href="#"  target="_blank">假期计划<span>(5)</span></a>
                            </li>
                            <li>
                                <a href="#"  target="_blank">世界巡回演唱会 <span>(7)</span></a>
                            </li>
                            <li>
                                <a href="#"  target="_blank">指导信息<span>(3)</span></a>
                            </li>
                            <li>
                                <a href="#"  target="_blank">旅行 <span>(6)</span></a>
                            </li>
                            <li>
                                <a href="#"  target="_blank"> 旅行 <span>(2)</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section><!-- All JavaScript files
    ================================================== -->
<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/owl.carousel.min.js"></script>

<!-- Plugins for this template -->
<script src="<%=request.getContextPath()%>/assets/js/jquery-plugin-collection.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/bootstrap-datepicker.min.js"></script>

<!-- Custom script for this template -->
<script src="<%=request.getContextPath()%>/assets/js/script.js"></script>

</body>

</html>
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
    <title>景点详情页面</title>
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
    <style type="text/css">
        .like {
            font-size: 26px;
            color: #ccc;
            cursor: pointer;
        }

        .cs {
            color: #f00;
        }
    </style>
    <script typet="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <script>
        $(function () {
            $(".like").click(function () {
                $(this).toggleClass('cs');
            })
        })
    </script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        $(function () {
            //页面加赞完毕后执行
            $(".like").click(function () {
                $(this).toggleClass('cs');
            })
            //异步提交评论
            $("#but_que").click(function () {
                // $("#commentform").
                alert("点击了")
                $.post("<%=request.getContextPath()%>/travelremark/remark/remarkServlet.do?method=saveRemarkComment", $("#commentform").serialize(), function (data) {

                })
            })

        })
    </script>
    <style type="text/css">
        #imageListZhan img {
            width: 500px;
            height: 500px;
        }
    </style>
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
                            <li><i class="fi ti-location-pin"></i>${city.cityName}</li>
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
                                <a href="index.html" target="_blank">主页 </a>
                            </li>
                            <li>
                                <a href="release.html#Contact" target="_blank">发布 </a>
                            </li>
                            <li>
                                <a href="search.html#selectdw1" target="_blank">搜索</a>
                            </li>
                        </ul>
                        <!--搜索框-->
                        <div class="col-sm-6" style="padding-top: 30px;">
                            <div class="input-group">
                                <input type="text" class="form-control input-lg"><span
                                    class="input-group-addon btn btn-primary"><i class="ti-search"></i></span>
                            </div>
                        </div>
                        <!--搜索框-->
                    </div>
                </div>
            </nav>
        </header>
        <!--第二行 头区域 logo 以及 各个页面跳转 搜索功能-->
    </div>

</div>
<!--第二行 头区域 logo 以及 各个页面跳转 搜索功能-->

<!-- 上方大图  删则空白地方较大 -->
<section class="page-title">
    <div class="container">
        <div class="row">
            <div class="col col-xs-12">
                <h2>Blog Details</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../../../../../../../../qq/主页模板/index.html">Home</a>
                    </li>
                    <li>Blog Details</li>
                </ol>
            </div>
        </div>
        <!-- end row -->
    </div>
    <!-- end container -->
</section>
<!-- 上方大图  -->
<section class="wpo-blog-pg-section section-padding">
    <div class="container">
        <div class="row">
            <div class="col col-md-12">
                <div class="wpo-blog-content">
                    <div class="post format-gallery">
                        <div class="entry-media post-slider">
                            <!--图片放置区域-->
                            <c:forEach var="image" items="${remarkImageList}">
                                <img src="${image.remarkimageName}" alt>
                            </c:forEach>
                        </div>
                        <!--可保留的样式-->
                        <!--可保留的样式-->
                        <ul class="entry-meta">
                            <li><a href="#"> By Robert harry</a></li>
                            <li><a href="#"> ${remark.remarkTimeStr}</a></li>
                        </ul>
                        <h3 style="text-align: center">${remark.remarkTitle}</h3>
                        <p style="font-size: 25px;letter-spacing: 10px">${remark.remarkText}</p>
                        <div class="entry-bottom" style="float: right;">
                            <ul>
                                <li><i class="fi flaticon-heart"></i>80</li>
                                <li>
                                    <a href="404.html"><i class="fi flaticon-share"></i></a>
                                </li>
                            </ul>
                        </div>
                        <div class="blog-thumb-badge">
                            <div class="blog-thumb-text">
                                <span>TravelRemark</span>
                            </div>
                        </div>
                        <!--可保留的样式-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--轮播图-->

<!-- start wpo-blog-single-section -->
<section class="wpo-blog-single-section section-padding">
    <div class="container">
        <div class="row">
            <div class="col col-md-12">
                <div class="wpo-blog-content clearfix">
                    <div class="post">
                        <!--引号部分-->
                        <blockquote>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                            incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida.
                        </blockquote>
                        <!--引号部分-->
                        <!--标签-->
                        <!--标签-->
                        <div class="tag-share clearfix">
                            <div class="tag">
                                <ul>
                                    <li>
                                        <a href="404.html">可以放标签</a>
                                    </li>
                                    <li>
                                        <a href="404.html">旅行</a>
                                    </li>
                                    <li>
                                        <a href="404.html">风景</a>
                                    </li>
                                </ul>
                            </div>
                            <!--标签-->
                            <!--分享 可设计图标-->
                            <div class="tag" style="float: right;">
                                <ul>
                                    <li>
                                        <a>
                                            <p style="float: left;" class="like">&#10084;</p>点赞</a>
                                    </li>
                                    <li>
                                        <a href="404.html"><i class="ti-link">分享</i></a>
                                    </li>
                                    <li>
                                        <a href="404.html"><i class="ti-alert">举报</i></a>
                                    </li>
                                    <li>
                                        <a href="404.html"><i class="ti-star">收藏</i></a>
                                    </li>
                                </ul>
                            </div>
                            <!--分享-->
                        </div>
                        <!-- end tag-share -->

                        <!--留言功能-->
                        <div class="comments-area">
                            <div class="comments-section">
                                <h3 class="comments-title">留言</h3>
                                <ol class="comments">
                                    <c:forEach items="${remarkCommentList}" var="remarkComment">
                                        <li class="comment even thread-even depth-1" id="comment-1">
                                            <div id="div-comment-1">
                                                <div class="comment-theme">
                                                        <%--头像--%>
                                                    <div class="comment-image"><img
                                                            src="<%=request.getContextPath()%>/assets/images/blog-details/comments-author/img-1.jpg"
                                                            alt></div>
                                                </div>
                                                <div class="comment-main-area">
                                                    <div class="comment-wrapper">
                                                        <!--用户名以及时间-->
                                                        <div class="comments-meta">
                                                            <h4>${remarkComment.userMap.user_name}<span
                                                                    class="comments-date">${remarkComment.remarkcommentTimeStr}</span>
                                                            </h4>
                                                        </div>
                                                        <!--用户名以及时间-->
                                                        <!--留言数据以及点赞-->
                                                        <div class="comment-area">
                                                            <p> ${remarkComment.remarkcommentText}</p>
                                                            <!--回复弹窗-->
                                                            <div class="comments-reply">
                                                                <a class="comment-reply-link" href="javascript:;"><i
                                                                        class="fa fa-reply"
                                                                        aria-hidden="true"></i><span>回复</span></a>
                                                            </div>
                                                            <!--回复弹窗-->
                                                        </div>
                                                        <!--点赞心-->
                                                        <div class="entry-bottom">
                                                            <!--占位P标签-->
                                                            <p class="read-more"></p>
                                                            <ul>
                                                                <p class="like">&#10084;</p>
                                                            </ul>
                                                        </div>
                                                        <!--点赞心-->
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ol>
                            </div>
                            <!--发布留言区-->
                            <div class="comment-respond">
                                <h3 class="comment-reply-title">发布评论</h3>
                                <form method="post" id="commentform" class="comment-form" action="">
                                    <div class="form-textarea">
                                            <textarea id="comment" placeholder="请输入留言..."
                                                      name="remarkComment"></textarea>
                                        <input type="text" name="remarkId" value="${remark.remarkId}"
                                               style="display: none">
                                    </div>
                                    <div class="form-submit">
                                        <input id="but_que" value="发布" type="button">
                                    </div>
                                </form>
                            </div>
                            <!--发布留言区-->
                        </div>
                        <!-- end comments-area -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end container -->
<!-- end wpo-blog-single-section -->


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
<script type="text/javascript">
    $(function () {
        //页面加载完毕后开始执行的事件
        $(".comment-reply-link").click(function () {
            $(".reply_textarea").remove();
            $(this).parent().append("<div class='reply_textarea'><div class=‘row’><textarea class=‘form-control’ id=‘huifu’ name=‘huifu’></textarea><input type='submit' value='发布' /></div></div>");
        });
    });
</script>
</body>

</html>

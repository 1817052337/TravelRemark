<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">

<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="wpoceans">

    <!-- Page Title -->
    <title>搜索页面</title>

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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/duoweistyle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/duoweijquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/duoweiscript.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

    <script type="text/javascript">
       $(function () {
           //alert("启动")
           //页面加赞完毕，隐藏标签属性
           $("#selectdw2").hide()

           $("#selectdw1 dd").click(function () {
               //alert("淡了")
               var travelremarkmoduleName =  $("#selectdwA a").text();
              //alert(travelremarkmoduleName)

               if (travelremarkmoduleName.length != 0 && travelremarkmoduleName != null) {
                   //显示标签div
                   $("#selectdw2").show()
               }else {
                   $("#selectdw2").hide()
               }

               var travelremarklabelName =  $("#yixuan #selectdwB a").text();
               var areaName =  $("#yixuan #selectdwC a").text();

                //alert(travelremarklabelName)
               //alert(areaId)
               //发送异步请求提交数据
               $.post("/travelremark/travelRemarkShow.do?method=findByLikeLableAndModuleAndArea",{travelremarkmoduleName:travelremarkmoduleName,travelremarklabelName:travelremarklabelName,areaName:areaName},function (data) {

               })
           })


          /* $("#selectdw1").click(function () {
               //alert("淡了")
               var areaId =  $("#selectdwC span").text();
               alert(areaId)
           })

           $("#selectdw1").click(function () {
               //alert("淡了")
              var areaId =  $("#selectdwC span").text();
              alert(areaId)
           })*/
       })
    </script>
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



<!--Logo以及主页 搜索栏-->
<!--多维搜索-->
<div class="row" style="">
    <ul class="selectdw" id="selectdw">
        <%--景点和点评模块--%>
        <li class="selectdw-list">
            <dl id="selectdw1">
                <dt>模块：</dt>
                <dd class="selectdw-all selectdwed  <c:if test="${flag==false}"></c:if>">
                    <%--<%=request.getContextPath()%>/travelremark/travelRemarkShow.do?method=findByLikeLabelAndModule&moduleId=--%>
                    <a href="#">全部</a>
                </dd>
                <c:forEach var="module" items="${moduleList}">
                    <dd>
                        <a href="#">${module.travelremarkmoduleName}</a>
                    </dd>
                </c:forEach>
            </dl>
        </li>
        <%--景点和点评标签--%>
        <li class="selectdw-list">
            <dl id="selectdw2">
                <dt>标签：</dt>
                <dd class="selectdw-all selectdwed">
                    <a href="#">全部</a>
                </dd>
                <c:forEach items="${labelList}" var="label">
                    <dd>
                        <a href="#">${label.travelremarklabelName}</a>
                    </dd>
                </c:forEach>
            </dl>
        </li>
        <%--点和点评地区--%>
        <li class="selectdw-list">
            <dl id="selectdw3">
                <dt>地区：</dt>
                <dd class="selectdw-all selectdwed">
                    <a href="#">全部</a>
                </dd>
                <c:forEach items="${areaList}" var="area">
                    <dd>
                        <a href="#">${area.areaName}</a>
                    </dd>
                </c:forEach>
            </dl>
        </li>
        <li class="selectdw-result">
            <dl id="yixuan">
                <dt>已选条件：</dt>
            </dl>
        </li>
    </ul>
</div>

<!--搜索的内容开始-->
<div class="row">
    <section class="wpo-blog-pg-section blog-pg-left-sidebar section-padding">
        <div class="container">
            <div class="row">
                <div class="col col-md-8 col-md-push-4">
                    <div class="wpo-blog-content">
                        <div class="post format-standard-image">
                            <div class="container">
                                <!--搜索的地方  栅格系统可552-->
                                <div class="row">
                                    <!--图片-->
                                    <div class="col-sm-4">
                                        <div class="entry-media">
                                            <img src="<%=request.getContextPath()%>/assets/images/blog/img-4.jpg" class="img-thumbnail">
                                        </div>
                                    </div>
                                    <!--图片-->
                                    <!--景点详情-->
                                    <div class="col-sm-4">
                                        <br />
                                        <h3><a href="#">地方名</a></h3>
                                        <div class="review-text">
                                            <div class="r-title">
                                                <ul>
                                                    <li><i class="fi flaticon-star"></i></li>
                                                    <li><i class="fi flaticon-star"></i></li>
                                                    <li><i class="fi flaticon-star"></i></li>
                                                    <li><i class="fi flaticon-star"></i></li>
                                                    <li><i class="fi flaticon-star"></i></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <p>（假数据）所有的学生都在学习，都在学习，所有的毕业生都在学习，都在学习。</p>
                                        <a class="theme-btn-s2" href="release.html" target="_blank">写评论 </a>
                                        <div class="entry-bottom col-md-offset-10">
                                            <ul>
                                                <li><i class="fi flaticon-heart"></i>80</li>
                                                <li>
                                                    <a href="#" target="_blank"><i class="fi flaticon-share"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <!--景点详情-->
                                        <div class="col-sm-4"></div>
                                    </div>
                                </div>
                                <!--搜索的地方-->
                                <!--热门评论 跳转评论详情页面-->
                                <div class="row">
                                    <div class="col-sm-8">
                                        <div class="post post-text-wrap">
                                            <!--标题-->
                                            <h3><a href="#" target="_blank">(标题)36/5000 巴黎的17个你不能忽视的地方</a></h3>
                                            <!--标题-->
                                            <ul class="entry-meta">
                                                <li>
                                                    <!--作者-->
                                                    <a href="#"> 作者:罗伯特·哈里</a>
                                                    <!--作者-->
                                                </li>
                                                <li>
                                                    <a href="#"> 时间：2020 11 25</a>
                                                </li>
                                            </ul>
                                            <!--点评内容-->
                                            <p>（假数据点评）所有的学生都在学习，都在学习，所有的毕业生都在学习，都在学习。</p>
                                            <!--点评内容-->
                                            <div class="entry-bottom col-md-offset-11">
                                                <ul>
                                                    <!--点赞数-->
                                                    <li><i class="fi flaticon-heart"></i>80</li>
                                                    <!--点赞数-->
                                                    <!--分享按钮-->
                                                    <li><a href="#" target="_blank"><i class="fi flaticon-share"></i></a></li>
                                                    <!--分享按钮-->
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <!--热门评论 跳转评论详情页面-->
                            </div>
                        </div>



                        <c:forEach items="${remarkList}" var="remark">
                            <div class="post format-gallery">
                                <div class="entry-media post-slider">
                                    <img src="<%=request.getContextPath()%>/assets/images/blog/img-5.jpg" alt>
                                    <img src="<%=request.getContextPath()%>/assets/images/blog/img-4.jpg" alt>
                                </div>
                                <ul class="entry-meta">
                                    <li>
                                        <a href="#"> 由罗伯特·哈利</a>
                                    </li>
                                    <li>
                                        <a href="#"> 时间：2020 11 25</a>
                                    </li>
                                </ul>
                                <h3><a href="#" target="_blank">你在迪拜一定要看的东西</a></h3>
                                <p>所有的学生都在学习，都在学习，所有的毕业生都在学习，都在学习。</p>
                                <div class="entry-bottom">
                                    <a href="#" class="read-more" target="_blank">View More...</a>
                                    <ul>
                                        <li><i class="fi flaticon-heart"></i>80</li>
                                        <li><i class="fi flaticon-share"></i></li>
                                    </ul>
                                </div>
                                <div class="blog-thumb-badge">
                                    <div class="blog-thumb-text">
                                        <span>旅行</span>
                                    </div>
                                </div>
                            </div>
                            <div class="post post-text-wrap">
                                <div class="post-bloquote">
                                    <p>${remark.remarkTitle}</p>
                                    <span>Robert Harry</span>
                                </div>
                                <div class="blog-thumb-text">
                                    <span>旅行</span>
                                </div>
                                <ul class="entry-meta">
                                    <li>
                                        <a href="#">${remark.userMap.user_name}</a>
                                    </li>
                                    <li>
                                        <a href="#">${remark.remarkTimeStr}</a>
                                    </li>
                                </ul>
                                <h3><a href="#" target="_blank">${remark.remarkTitle}</a></h3>
                                <p>${remark.remarkText}</p>
                                <div class="entry-bottom">
                                    <a href="#" class="read-more" target="_blank">View More...</a>
                                    <ul>
                                        <li><i class="fi flaticon-heart"></i>80</li>
                                        <li><i class="fi flaticon-share"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col col-md-4 col-md-pull-8">
                    <div class="wpo-blog-sidebar">
                        <div class="widget profile-widget">
                            <div class="profile-img">
                                <img src="<%=request.getContextPath()%>/assets/images/blog/profile.png" alt="">
                                <h2>小车的宝贝有内涵i</h2>
                                <h4>参考城市：保定</h4>
                                <p>欢迎来到旅游点评，在家就可以环游世界，我们与你同在！</p>

                            </div>
                            <div class="modebox person-info">
                                <div class="con">
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
                                    </div>
                                    <div class="user-time">
                                        <p><span class="col-exp">注册时间：</span>2019-03-30</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="widget search-widget">
                            <form>
                                <div>
                                    <input type="text" class="form-control" placeholder="输入关键字...">
                                    <button type="submit"><i class="ti-search"></i></button>
                                </div>
                            </form>
                        </div>
                        <div class="widget category-widget">
                            <h3>类别</h3>
                            <ul>
                                <li>
                                    <a href="#" target="_blank">酒店管理<span>(8)</span></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">假期计划<span>(5)</span></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">世界巡回演唱会 <span>(7)</span></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank"> 指导信息<span>(3)</span></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">旅行 <span>(6)</span></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">旅行 <span>(2)</span></a>
                                </li>
                            </ul>
                        </div>
                        <div class="widget recent-post-widget">
                            <h3>最近的帖子</h3>
                            <div class="posts">
                                <div class="post">
                                    <div class="img-holder">
                                        <img src="<%=request.getContextPath()%>/assets/images/recent-posts/img-1.jpg" alt>
                                    </div>
                                    <div class="details">
                                        <h4><a href="#" target="_blank">世界上十大最美的地方。</a></h4>
                                        <span class="date">2020年9月22日</span>
                                    </div>
                                </div>
                                <div class="post">
                                    <div class="img-holder">
                                        <img src="<%=request.getContextPath()%>/assets/images/recent-posts/img-2.jpg" alt>
                                    </div>
                                    <div class="details">
                                        <h4><a href="#" target="_blank">5个简单的步骤让你更快乐，更健康</a></h4>
                                        <span class="date">2020年9月22日</span>
                                    </div>
                                </div>
                                <div class="post">
                                    <div class="img-holder">
                                        <img src="<%=request.getContextPath()%>/assets/images/recent-posts/img-3.jpg" alt>
                                    </div>
                                    <div class="details">
                                        <h4><a href="#" target="_blank">开启你的梦想旅馆——简单的5步</a></h4>
                                        <span class="date">2020年9月22日</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="widget instagram">
                            <h3>画廊</h3>
                            <ul class="d-flex">
                                <li>
                                    <a href="#" target="_blank"><img src="<%=request.getContextPath()%>/assets/images/instragram/1.jpg" alt=""></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank"><img src="<%=request.getContextPath()%>/assets/images/instragram/2.jpg" alt=""></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank"><img src="<%=request.getContextPath()%>/assets/images/instragram/3.jpg" alt=""></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank"><img src="<%=request.getContextPath()%>/assets/images/instragram/4.jpg" alt=""></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank"><img src="<%=request.getContextPath()%>/assets/images/instragram/5.jpg" alt=""></a>
                                </li>
                                <li>
                                    <a href="#" target="_blank"><img src="<%=request.getContextPath()%>/assets/images/instragram/6.jpg" alt=""></a>
                                </li>
                            </ul>
                        </div>
                        <div class="widget tag-widget">
                            <h3>标签</h3>
                            <ul>
                                <li>
                                    <a href="#" target="_blank">旅行</a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">酒店</a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">餐厅</a>
                                </li>
                                <li>
                                    <a href="destination.html" target="_blank">目的地</a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">世界巡回演唱会</a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">酒店房间</a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">水疗中心</a>
                                </li>
                                <li>
                                    <a href="#" target="_blank">指南</a>
                                </li>
                            </ul>
                        </div>
                        <div class="widget get-intouch">
                            <div class="get-item">
                                <img src="<%=request.getContextPath()%>/assets/images/blog/icon.png" alt="">
                                <h2>让我们开始你的梦幻之旅</h2>
                                <a class="theme-btn" href="#" target="_blank">取得联系</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end container -->
    </section>
</div>
<!-- end wpo-blog-pg-section -->
<!--搜索的内容结束-->
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
</body>

</html>

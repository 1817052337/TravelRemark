<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="wpoceans">
    <!-- Page Title -->
    <title>首页</title>

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
    <%--设置点评展示的图片大小--%>
    <style type="text/css">
        #remarkDiv div div div img {
            height: 450px;
            width: 422px;
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=CyuMQjRd8numjt8fQyFPLb684zTUzPgY"></script>
    <script type="text/javascript">
        $(function () {
            //alert("地隔热")
            //页面加载完毕，获取当前用户所在的城市
            $("#area").text("正在获取位置......");
            //创建百度地图控件
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function (r) {
                // alert("丁文")
                if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                    //以指定的经度与纬度创建一个坐标点
                    var pt = new BMap.Point(r.point.lng, r.point.lat);
                    //创建一个地理位置解析器
                    var geoc = new BMap.Geocoder();
                    geoc.getLocation(pt, function (rs) { //解析格式：城市，区县，街道
                        var addComp = rs.addressComponents;
                        $("#area").text(addComp.city);
                    });

                } else {
                    $(ev.currentTarget).text('定位失败');
                }
            }, {
                enableHighAccuracy: true
            }); //指示浏览器获取高精度的位置，默认false

            //alert("点击了")
            //点击图片 进行跳转到详情页

        });

    </script>
</head>

<body id="home">

<header id="header">
    <!--start topbar-->
    <div class="topbar">
        <div class="container-fluid">
            <div class="row">
                <div class="col col-md-6 col-sm-7 col-12">
                    <div class="contact-intro">
                        <ul>
                            <li><i class="fi ti-location-pin" id="area"></i></li>
                            <li><i class="fi flaticon-email"></i> ${userMap.user_email}</li>
                        </ul>
                    </div>
                </div>
                <div class="col col-md-6 col-sm-5 col-12">
                    <div class="contact-info">
                        <ul>
                            <li><a href="#"><i class="ti-facebook"></i></a></li>
                            <li><a href="#"><i class="ti-twitter-alt"></i></a></li>
                            <li><a href="#"><i class="ti-instagram"></i></a></li>
                            <li><a href="#"><i class="ti-google"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/user/userservlet.do?method=judgeuser"
                                   class="search-toggle-btn"><i class="ti-user"></i></a></li>
                            <li><a class="theme-btn-s2" href="#">查看详情 </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end topbar -->
</header>

<!-- start page-wrapper -->
<div class="page-wrapper">

    <!-- start preloader -->
    <div class="preloader">
        <div class="spinner">
            <div class="bounce1"></div>
            <div class="bounce2"></div>
            <div class="bounce3"></div>
        </div>
    </div>
    <!-- end preloader -->
    <!-- Start header -->
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
                            <form action="<%=request.getContextPath()%>/travelremark/travelRemarkShow.do?method=findByLikeTravelRemark" method="post" >
                                <div>
                                    <input type="text" name="travelremark_search" class="form-control" placeholder="Search here...">
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
    <!-- end of header -->
    <!-- start of hero -->
    <section class="hero hero-style-1">
        <div class="hero-slider">
            <div class="slide">
                <div class="container">
                    <img src="assets/images/slider/slide-1.jpg" alt class="slider-bg">
                    <div class="row">
                        <div class="col col-md-8 slide-caption">
                            <div class="btns">
                                <a href="<%=request.getContextPath()%>/travelremark/regon/province.do?method=provinceAll"
                                   class="theme-btn">写点评</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="slide">
                <div class="container">
                    <img src="assets/images/slider/slide-2.jpg" alt class="slider-bg">
                    <div class="row">
                        <div class="col col-md-8 slide-caption">
                            <div class="slide-title">
                                <h2>编辑</h2>
                            </div>
                            <div class="slide-subtitle">
                                <p>小编辑</p>
                            </div>
                            <div class="btns">
                                <a href="#" class="theme-btn">查看详情</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="slide">
                <div class="container">
                    <img src="assets/images/slider/slide-3.jpg" alt class="slider-bg">
                    <div class="row">
                        <div class="col col-md-8 slide-caption">
                            <div class="slide-title">
                                <h2>编辑</h2>
                            </div>
                            <div class="slide-subtitle">
                                <p>小编辑</p>
                            </div>
                            <div class="btns">
                                <a href="#" class="theme-btn">查看详情</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- end of hero slider -->
    <!-- serch-area-start -->
    <div class="wpo-select-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="wpo-select-wrap">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="destination-area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="destination-text">
                        <div class="wpo-section-title">
                            <span>推荐 </span>
                            <h2>热门景点 </h2>
                        </div>
                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have
                            suffered alteration in some form, by injected humour, or randomised words which don't look
                            even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be
                            sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum
                            generators.</p>
                        <div class="btns">
                            <a href="about.html" class="theme-btn-s2" tabindex="0">查看更多</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="destination-wrap">
                        <div class="row">
                            <div class="col-md-6 col-sm-6 custom-grid">
                                <div class="destination-left">
                                    <div class="destination-item">
                                        <div class="destination-img">
                                            <img src="assets/images/destination/img-1.jpg" alt="">
                                        </div>
                                        <div class="destination-content">
                                            <div class="content-left">
                                                <h5>Paris, France</h5>
                                                <small>11 Jun 2020 - 22 Jun 2020</small>
                                            </div>
                                            <div class="content-right">

                                                <span>Per Day</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="destination-item">
                                        <div class="destination-img">
                                            <img src="assets/images/destination/img-2.jpg" alt="">
                                        </div>
                                        <div class="destination-content">
                                            <div class="content-left">
                                                <h5>San Francisco</h5>
                                                <small>11 Jun 2020 - 22 Jun 2020</small>
                                            </div>
                                            <div class="content-right">
                                                <span>Per Day</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6 custom-grid">
                                <div class="destination-right">
                                    <div class="destination-item">
                                        <div class="destination-img">
                                            <img src="assets/images/destination/img-3.jpg" alt="">
                                        </div>
                                        <div class="destination-content">
                                            <div class="content-left">
                                                <h5>United Arab</h5>
                                                <small>11 Jun 2020 - 22 Jun 2020</small>
                                            </div>
                                            <div class="content-right">
                                                <span>Per Day</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="destination-item">
                                        <div class="destination-img">
                                            <img src="assets/images/destination/img-4.jpg" alt="">
                                        </div>
                                        <div class="destination-content">
                                            <div class="content-left">
                                                <h5>Singapore</h5>
                                                <small>11 Jun 2020 - 22 Jun 2020</small>
                                            </div>
                                            <div class="content-right">
                                                <span>Per Day</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="destination-service section-padding">
        <div class="container">
            <div class="col-12">
                <div class="wpo-section-title text-center">
                    <span>推荐</span>
                    <h2>点评</h2>
                </div>
            </div>
            <div class="destination-carousel owl-carousel owl-theme owl-btn-center-lr owl-dots-primary-full owl-btn-3 m-b30 wow fadeIn"
                 data-wow-duration="2s" data-wow-delay="0.2s" id="remarkDiv">
                <c:forEach items="${remarks}" var="remark">
                    <div class="item" id="">
                        <div class="destination-item">
                            <div class="destination-img">
                                <a href="<%=request.getContextPath()%>/travelremark/remark/remarkServlet.do?method=findByIdRemark&remarkId=${remark.remarkId}"> <img src="${remark.remarkImage}" alt=""></a>
                            </div>
                            <div class="destination-content">
                                <div class="content-left">
                                    <h5>${remark.remarkTitle}</h5>
                                    <small>${remark.remarkTimeStr}</small>
                                </div>
                                    <%-- <div class="content-right">
                                         <span>Per Day</span>
                                     </div>--%>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <%--
                                <div class="item" id="这是点评id">
                                    <div class="destination-item">
                                        <div class="destination-img">
                                            <img src="assets/images/destination/img-6.jpg" alt="">
                                        </div>
                                        <div class="destination-content">
                                            <div class="content-left">
                                                <h5>United Arab</h5>
                                                <small>11 Jun 2020 - 22 Jun 2020</small>
                                            </div>
                                            <div class="content-right">
                                                <span>Per Day</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>  <div class="item" id="这是点评id">
                                <div class="destination-item">
                                    <div class="destination-img">
                                        <img src="assets/images/destination/img-6.jpg" alt="">
                                    </div>
                                    <div class="destination-content">
                                        <div class="content-left">
                                            <h5>United Arab</h5>
                                            <small>11 Jun 2020 - 22 Jun 2020</small>
                                        </div>
                                        <div class="content-right">
                                            <span>Per Day</span>
                                        </div>
                                    </div>
                                </div>
                            </div>  <div class="item" id="这是点评id">
                                <div class="destination-item">
                                    <div class="destination-img">
                                        <img src="assets/images/destination/img-6.jpg" alt="">
                                    </div>
                                    <div class="destination-content">
                                        <div class="content-left">
                                            <h5>United Arab</h5>
                                            <small>11 Jun 2020 - 22 Jun 2020</small>
                                        </div>
                                        <div class="content-right">
                                            <span>Per Day</span>
                                        </div>
                                    </div>
                                </div>
                            </div>  <div class="item" id="这是点评id">
                                <div class="destination-item">
                                    <div class="destination-img">
                                        <img src="assets/images/destination/img-6.jpg" alt="">
                                    </div>
                                    <div class="destination-content">
                                        <div class="content-left">
                                            <h5>United Arab</h5>
                                            <small>11 Jun 2020 - 22 Jun 2020</small>
                                        </div>
                                        <div class="content-right">
                                            <span>Per Day</span>
                                        </div>
                                    </div>
                                </div>
                            </div>--%>
                <%--         <div class="item">
                             <div class="service-media-bx">
                                 <div class="destination-item">
                                     <div class="destination-img">
                                         <img src="assets/images/destination/img-5.jpg" alt="">
                                     </div>
                                     <div class="destination-content">
                                         <div class="content-left">
                                             <h5>地区名字</h5>
                                             <small>11 Jun 2020 - 22 Jun 2020</small>
                                         </div>
                                         <div class="content-right">
                                             <span>Per Day</span>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="item">
                             <div class="service-media-bx">
                                 <div class="destination-item">
                                     <div class="destination-img">
                                         <img src="assets/images/destination/img-9.jpg" alt="">
                                     </div>
                                     <div class="destination-content">
                                         <div class="content-left">
                                             <h5>Singapore</h5>
                                             <small>11 Jun 2020 - 22 Jun 2020</small>
                                         </div>
                                         <div class="content-right">
                                             <span>Per Day</span>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="item">

                             <div class="service-media-bx">
                                 <div class="destination-item">
                                     <div class="destination-img">
                                         <img src="assets/images/destination/img-7.jpg" alt="">
                                     </div>
                                     <div class="destination-content">
                                         <div class="content-left">
                                             <h5>San Francisco</h5>
                                             <small>11 Jun 2020 - 22 Jun 2020</small>
                                         </div>
                                         <div class="content-right">
                                             <span>Per Day</span>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="item">

                             <div class="service-media-bx">
                                 <div class="destination-item">
                                     <div class="destination-img">
                                         <img src="assets/images/destination/img-8.jpg" alt="">
                                     </div>
                                     <div class="destination-content">
                                         <div class="content-left">
                                             <h5>Singapore</h5>
                                             <small>11 Jun 2020 - 22 Jun 2020</small>
                                         </div>
                                         <div class="content-right">
                                             <span>Per Day</span>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>--%>
            </div>
        </div>
    </div>
    <!-- .Destination-area-start -->
    <!--Start Room area-->
    <section class="Room-area section-padding">
        <div class="Room-section">
            <div class="container">
                <div class="col-12">
                    <div class="wpo-section-title">
                        <span>景点</span>
                        <h2>发现好玩的景点</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-xs-12 sortable-gallery">
                        <div class="gallery-filters">
                            <ul>
                                <li><a data-filter=".Classic" href="#" class="current">山水</a></li>
                                <li><a data-filter=".Budget" href="#">古迹</a></li>
                                <li><a data-filter=".Luxury" href="#">探险</a></li>
                                <li><a data-filter=".Double" href="#">名胜</a></li>
                                <li><a data-filter=".Single" href="#">更多</a></li>
                            </ul>
                        </div>
                        <div class="gallery-container gallery-fancybox masonry-gallery">
                            <div class="grid  Luxury Double Single Classic">
                                <div class="room-item">
                                    <img src="assets/images/room/img-1.jpg" alt class="img img-responsive">
                                    <div class="room-text-show">
                                        <h2>Lake view Room</h2>
                                    </div>
                                    <div class="room-text-hide">
                                        <h2>Lake view Room</h2>
                                        <span>Twin Room</span>
                                        <p>If you are going to use a passage Lorem Ipsum, you need to be sure there
                                            isn't anything embarrassing hidden in the middle of text.</p>
                                        <a class="theme-btn-s2" href="#">Check Availability</a>
                                    </div>
                                </div>
                            </div>
                            <div class="grid Classic Luxury Single">
                                <div class="room-item">
                                    <img src="assets/images/room/img-2.jpg" alt class="img img-responsive">
                                    <div class="room-text-show">
                                        <h2>Queen Room Balcony</h2>
                                    </div>
                                    <div class="room-text-hide">
                                        <h2>Queen Room Balcony</h2>
                                        <span>Twin Room</span>
                                        <p>If you are going to use a passage Lorem Ipsum, you need to be sure there
                                            isn't anything embarrassing hidden in the middle of text.</p>
                                        <a class="theme-btn-s2" href="#">Check Availability</a>
                                    </div>
                                </div>
                            </div>
                            <div class="grid Budget Double Classic">
                                <div class="room-item">
                                    <img src="assets/images/room/img-3.jpg" alt class="img img-responsive">
                                    <div class="room-text-show">
                                        <h2>Apartment</h2>
                                    </div>
                                    <div class="room-text-hide">
                                        <h2>Apartment</h2>
                                        <span>Twin Room</span>
                                        <p>If you are going to use a passage Lorem Ipsum, you need to be sure there
                                            isn't anything embarrassing hidden in the middle of text.</p>
                                        <a class="theme-btn-s2" href="#">Check Availability</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- end row -->
            </div>
        </div>
    </section>
    <!--End Room area-->

    <!-- testimonial-area start -->
    <div class="testimonial-area section-padding">
        <div class="container">
            <div class="col-12">
                <div class="wpo-section-title">
                    <span>精选评论</span>
                    <h2>这些 <br> 不可错过的景点</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="testimonial-slider clearfix">
                        <div class="grid">
                            <div class="ratting">
                                <ul>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                </ul>
                            </div>
                            <div class="quote">
                                <p>“The trip was incredible. I got to see so many places I wouldn't have by myself, me
                                    and my husband really enjoyed a lot.”</p>
                            </div>
                            <div class="client-info">
                                <div class="client-img">
                                    <img src="assets/images/testimonial/img-1.jpg" alt="">
                                </div>
                                <div class="client-text">
                                    <h5>Benjir Walton</h5>
                                    <p>Singapore</p>
                                </div>
                            </div>
                        </div>
                        <div class="grid">
                            <div class="ratting">
                                <ul>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                </ul>
                            </div>
                            <div class="quote">
                                <p>“The trip was incredible. I got to see so many places I wouldn't have by myself, me
                                    and my husband really enjoyed a lot.”</p>
                            </div>
                            <div class="client-info">
                                <div class="client-img">
                                    <img src="assets/images/testimonial/img-2.jpg" alt="">
                                </div>
                                <div class="client-text">
                                    <h5>Jenefar Meera</h5>
                                    <p>Canada</p>
                                </div>
                            </div>
                        </div>
                        <div class="grid">
                            <div class="ratting">
                                <ul>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                    <li><i class="fi flaticon-star"></i></li>
                                </ul>
                            </div>
                            <div class="quote">
                                <p>“The trip was incredible. I got to see so many places I wouldn't have by myself, me
                                    and my husband really enjoyed a lot.”</p>
                            </div>
                            <div class="client-info">
                                <div class="client-img">
                                    <img src="assets/images/testimonial/img-3.jpg" alt="">
                                </div>
                                <div class="client-text">
                                    <h5>Lily monalisa</h5>
                                    <p>Singapore</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- testimonial-area end -->

</div>


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

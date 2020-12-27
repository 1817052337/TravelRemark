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
    <title>发布评论</title>
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
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="<%=request.getContextPath()%>/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
    <!--suppress JSUnresolvedLibraryURL -->
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="<%=request.getContextPath()%>/js/star-rating.js" type="text/javascript"></script>
    <style type="text/css">
        .yi {
            background: rgba(0, 0, 0, 0);
            /*背景色和透明度，可以设置为url地址的图片*/
            width: 200px;
            /*宽度*/
            height: 30px;
            /*高度*/
            margin-top: 10px;
            /*上边距*/
            /*margin-left: 150px;*/
            font-size: 10px;
            border-radius: 10px;
            overflow: hidden;
        }

        #result img {
            width: 200px;
            height: 200px;
        }
    </style>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=CyuMQjRd8numjt8fQyFPLb684zTUzPgY"></script>
    <![endif]-->
    <script>

        $(function () {

            //提交
            $("#que_but").click(function () {


                 if (remark_title && remark_text() && remark_allgrade() &&
                    remark_environmentgrade() && remark_servegrade()) {
                    //alert("加油")
                     var image = $("#image").val();
                     $.post("<%=request.getContextPath() %>/travelremark/remark/remarkServlet.do?method=saveRemark", $("#contact-form").serialize()+"&image="+image, function (data) {
                         if (data[0] == true) {
                             //alert(true)
                             //跳转到ok页面
                             var remarkId = data[1];
                             location.href = "<%=request.getContextPath()%>/travelremark/remark/remark_write_ok.jsp?remarkId="+remarkId;
                         }
                     })
                }
                // return false;
            });
            //图片判断
            $(document).off("change", "#image").on("change", "#image", checkImage);
            //根部省份id获取城市和地区标签
            $(document).off("change", "#provinceId").on("change", "#provinceId", checkProvinceId);
            // //根部城市id获取地区
            $(document).off("change", "#cityId").on("change", "#cityId", checkCity);
            //根据模块id获取标签
            $(document).off("change", "#remark_travel_module").on("change", "#remark_travel_module", checkLabel);

            $("#remark_title").blur(remark_title)
            $("#remark_text").blur(remark_text)
            $("#remark_allgrade").blur(remark_allgrade)
            $("#remark_environmentgrade").blur(remark_environmentgrade)
            $("#remark_servegrade").blur(remark_servegrade)

        });


        //根部省份id获取城市和地区标签
        function checkProvinceId() {
            var provinceId = $("#provinceId option:selected").val();
            // alert(provinceId)
            $.post("<%=request.getContextPath()%>/travelremark/regon/province.do?method=provinceId", {provinceId: provinceId}, function (data) {
                //alert(data);
                //删除select中的数据
                $("#cityId").empty();
                //var lis = "";
                var cityList = data[0];
                for (var i = 0; i < cityList.length; i++) {
                    //alert(data[i])
                    //alert(data[i].cityName)
                    var ciryName = cityList[i].cityName;
                    $("#cityId").append("<option value='" + cityList[i].cityId + "'>" + ciryName + "</option>")
                }
                //清空地区标签内容
                $("#areaId").empty();
                var areaList = data[1];
                for (var i = 0; i < areaList.length; i++) {
                    //alert(data[i])
                    $("#areaId").append("<option value='" + areaList[i].areaId + "'>" + areaList[i].areaName + "</option>");
                }
            })
        }

        // //根部城市id获取地区
        function checkCity() {
            var cityId = $("#cityId option:selected").val();
            //alert(cityId)
            $.post("<%=request.getContextPath()%>/travelremark/regon/province.do?method=cityId", {cityId: cityId}, function (data) {
                //alert(data);
                //删除select中的数据
                $("#areaId").empty();

                for (var i = 0; i < data.length; i++) {
                    //alert(data[i])
                    $("#areaId").append("<option value='" + data[i].areaId + "'>" + data[i].areaName + "</option>");
                }
            })
        }

        //根据模块id获取标签
        function checkLabel() {

            var travelremarkmoduleId = $("#remark_travel_module option:selected").val();
           // alert(travelremarkmoduleId)
            //发送post请求
            $.post("<%=request.getContextPath()%>/travelremark/travelRemarkModule.do?method=findByModuleIdLabel",{travelremarkmoduleId:travelremarkmoduleId},function (data) {
                //删除select中的数据
                $("#remark_travel_label").empty();
                for (var i = 0; i < data.length; i++) {
                    //alert(data[i])
                    //alert( data[i].travelremarklabelName)
                    $("#remark_travel_label").append("<option value='" + data[i].travelremarklabelId + "'>" + data[i].travelremarklabelName + "</option>");
                }
            })
        }

        //判断标题
        function remark_title() {
            // alert("叫叶娜")
            //获取标题的val值
            var remark_title = $("#remark_title").val();

            var flag = false;
            if (remark_title == null || remark_title.length == 0) {
                // alert("空")
                $("#remark_title").css("border", "1px solid red");
                flag = false;
            } else {
                $("#remark_title").css("border", "1px solid blue");
                flag = true;
            }

            return flag;
        }


        //判断内容
        function remark_text() {
            var flag = false;
            //获取文本内容
            var remark_text = $("#remark_text").val();
            //alert(remark_text)
            if (remark_text == null || remark_text.length == 0) {
                flag = false;
                $("#remark_text").css("border", "1px solid red");
            }
            if (remark_text.length <= 100) {
                var size = 100 - (remark_text.length);
                //alert(size)
                flag = false;
                alert("会说话就多说点吧(还差" + size + "个字)");
                $("#remark_text").css("border", "1px solid red");
            } else {
                $("#remark_text").css("border", "1px solid blue");
                flag = true;
            }
            return flag;
        }

        //判断图片
        function checkImage() {
            var flag = false;
            var imageName = $("#image").val();


            //alert(imageName);
            //var file = document.getElementById('image').files[0];
            //定义正则表达式
            var imageType = /^image\//;

            if (imageName != null && imageName.length > 0) {
                for (var a = 0; a < imageName.length; a++) {
                    //获取每一张图片的文本类型
                    var fileType = this.files[a].type;
                    //alert(fileType)
                    if (imageType.test(fileType)) {
                        //alert("是图片")
                        //alert(this.files[a])
                        var imagePath = this.files[a]
                        if (imagePath) {
                            var url = null;
                            //alert(imagePath)
                            if (window.createObjcectURL != undefined) {
                                url = window.createOjcectURL(imagePath);
                            } else if (window.URL != undefined) {
                                url = window.URL.createObjectURL(imagePath);
                            } else if (window.webkitURL != undefined) {
                                url = window.webkitURL.createObjectURL(imagePath);
                            }
                            var reader = new FileReader();
                            reader.onload = function (event) {
                                var txt = event.target.result;
                                // alert(txt)
                                // alert(imageName)
                                // alert(url)

                                var img = document.createElement("img");
                                img.src = txt; //将图片base64字符串赋值给img的src

                                // console.log(txt);

                                document.getElementById("result").appendChild(img);
                            };

                        }
                        reader.readAsDataURL(imagePath);
                        flag = true;
                    } else {
                        flag = false;
                        alert("不是图片")
                    }
                }
                flag = true;
            } else {
                flag = false;
                alert("请选择图片")
            }

            return flag;
        }

        //判断总评分
        function remark_allgrade() {
            var flag = false;
            //获取文本内容
            var remark_text = $("#remark_allgrade").val();
            if (remark_text == null || remark_text.length == 0) {
                alert("您还没有评分哦！")
                flag = false;
            } else {
                flag = true;
            }
            return flag;
        }

        //环境评分
        function remark_environmentgrade() {
            var flag = false;
            //获取文本内容
            var remark_text = $("#remark_environmentgrade").val();
            if (remark_text == null || remark_text.length == 0) {
                alert("您还没有评分哦！")
                flag = false;
            } else {
                flag = true;
            }
            return flag;
        }

        //服务评分
        function remark_servegrade() {
            var flag = false;
            //获取文本内容
            var remark_text = $("#remark_servegrade").val();
            if (remark_text == null || remark_text.length == 0) {
                alert("您还没有评分哦！")
                flag = false;
            } else {
                flag = true;
            }
            return flag;
        }


    </script>
</head>

<body id="home">
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
                    <button type="button" class="open-btn">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img
                            src="<%=request.getContextPath()%>/assets/images/logo-2.png" alt=""></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse navigation-holder">
                    <button class="close-navbar"><i class="ti-close"></i></button>
                    <ul class="nav navbar-nav">
                        <li class="menu-item-has-children">
                            <a href="javascript:void(0);">Home +</a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="index.html">Home</a>
                                </li>
                                <li>
                                    <a href="index-2.html">Home-style-2</a>
                                </li>
                                <li>
                                    <a href="index-3.html">Home-style-3</a>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children">
                            <a href="javascript:void(0);">Room +</a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="room.html">Room</a>
                                </li>
                                <li>
                                    <a href="room-single.html">Room Single</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="destination.html">Destination</a>
                        </li>
                        <li class="menu-item-has-children">
                            <a href="javascript:void(0);">Pages +</a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="about.html">About</a>
                                </li>
                                <li>
                                    <a href="faq.html">Faq</a>
                                </li>
                                <li>
                                    <a href="404.html">404</a>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children">
                            <a href="javascripThings You Must Need To See While You’re In DubaiThings You Must Need To See While You’re In Dubait:void(0);">Service
                                +</a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="service.html">service</a>
                                </li>
                                <li>
                                    <a href="service-single.html">Service Single</a>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children">
                            <a href="javascript:void(0);">Blog +</a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="blog.html">Blog</a>
                                </li>
                                <li>
                                    <a href="blog-left.html">Blog Left Sidebar</a>
                                </li>
                                <li>
                                    <a href="blog-fullwidth.html">Blog full width</a>
                                </li>
                                <li class="menu-item-has-children">
                                    <a href="#">Blog details</a>
                                    <ul class="sub-menu">
                                        <li>
                                            <a href="blog-single.html">Blog Single</a>
                                        </li>
                                        <li>
                                            <a href="blog-single-left.html">Blog Single Left</a>
                                        </li>
                                        <li>
                                            <a href="blog-single-fullwidth.html">Blog single fullwidth</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="contact.html">Contact</a>
                        </li>
                    </ul>
                </div>
                <!-- end of nav-collapse -->

                <div class="cart-search-contact">
                    <div class="header-search-form-wrapper">
                        <button class="search-toggle-btn"><i class="ti-search"></i></button>
                        <div class="header-search-form">
                            <form>
                                <div>
                                    <input type="text" class="form-control" placeholder="Search here...">
                                    <button type="submit"><i class="fi flaticon-search"></i></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end of container -->
        </nav>
    </header>
    <!-- end of header -->
    <!-- start page-title -->
    <section class="page-title">
        <div class="container">
            <div class="row">
                <div class="col col-xs-12">
                    <h2>Contact Us</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>Contact Us</li>
                    </ol>
                </div>
            </div>
            <!-- end row -->
        </div>
        <!-- end container -->
    </section>
    <!-- end page-title -->
    <!-- contact-area start -->
    <div id="Contact" class="section-padding">
        <div class="container">
            <div class="contact-content">
                <h2>点评</h2>
                <div class="row"></div>
                <div class="contact-form">
                    <form method="post" class="contact-validation-active" id="contact-form" action="">
                        <div class="row">
                            <div class="form-group " id="title">
                                <h3>标题</h3>
                                <input type="text" name="remark_title" value="" id="remark_title" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <h3>内容</h3>
                                <textarea class="form-control" style="height: 600px;font-size: 25px" name="remark_text"
                                          id="remark_text"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <h3>上传图片</h3>
                            <div class="form-group">
                                <input type="file" name="image" id="image" value="" multiple/>
                            </div>
                            <div class="form-group" id="result">

                            </div>
                        </div>

                        <div class="row"><h3>评分：</h3>
                            <div class="form-group">
                                <h4>总评分:</h4><input value="" name="remark_allgrade" id="remark_allgrade"
                                                    type="text" class="rating" data-min=0
                                                    data-max=5 data-step=0.5 data-size="sm" title="">
                                <h4>环境评分:</h4><input value="" type="text" id="remark_environmentgrade"
                                                     name="remark_environmentgrade" class="rating"
                                                     data-min=0 data-max=5
                                                     data-step=0.5 data-size="sm" title="">
                                <h4>服务评分:</h4><input value="" id="remark_servegrade" name="remark_servegrade"
                                                     type="text" class="rating"
                                                     data-min=0 data-max=5
                                                     data-step=0.5 data-size="sm" title="">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group ">
                                <h3>景点名称</h3>
                                <input type="text" name="remark_travel" value="" id="remark_travel"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                省份
                                <label class="input-field">
                                    <select class="yi" name="provinceId" id="provinceId">
                                        <c:forEach var="province" items="${findAllProvince}">
                                            <option value="${province.provinceId}">${province.provinceName}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                                城市
                                <label class="input-field">
                                    <select class="yi" id="cityId" name="cityId">
                                        <option value="${city.cityId}">${city.cityName}</option>
                                    </select>
                                </label>
                                地区
                                <label class="input-field">
                                    <select class="yi" id="areaId" name="areaId">
                                        <c:forEach var="area" items="${areaList}">
                                            <option value="${area.areaId}">${area.areaName}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                景点所属模块
                                <label class="input-field">
                                    <select class="yi" id="remark_travel_module" name="remark_travel_module">
                                        <c:forEach var="module" items="${moduleList}">
                                            <option value="${module.travelremarkmoduleId}">${module.travelremarkmoduleName}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                                景点所属标签
                                <label class="input-field">
                                    <select class="yi" id="remark_travel_label" name="remark_travel_label">
                                        <c:forEach var="label" items="${labelList}">
                                            <option value="${label.travelremarklabelId}">${label.travelremarklabelName}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
                        </div>
                        <div class="submit-btn-wrapper">
                            <button type="button" class="theme-btn-s2" style="text-align: center;" id="que_but">提交
                            </button>
                            <div id="loader">
                                <i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>
                            </div>
                        </div>
                        <div class="clearfix error-handling-messages">
                            <div id="success">Thank you</div>
                            <div id="error"> Error occurred while sending email. Please try again later.</div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- contact-area end -->

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
<script src="<%=request.getContextPath()%>/js/starjquery.js"></script>
</body>
</html>
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
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <style type="text/css">
        #preview{
            width: 170px;
            height: 170px;
        }
    </style>
    <script type="text/javascript">

        $(function () {
            //页面加载完毕后校验
            $(document).off("change","#user_image").on("change","#user_image",checkImage);

            $("#sex-man").click(function () {
                alert($("#sex-man").val())
            })

            $("#que_but").click(function () {
                if (checkImage()) {
                    //提交表单
                    $("#")
                }
            })
        })

        //校验图片
        function checkImage() {
            //alert("点击了")
            //设置boolean变量
            var flag = false;
//alert($("#user_image").val())
            if (window.FileReader) {
                if ($("#user_image").val()==null || $("#user_image").val().length  == 0){
                    flag = false;
                }else {
                    //获取图片类型
                    var fileType = this.files[0].type;

                    //定义正则表达式
                    var imageType = /^image\//;

                    //判断文件类型是否是图片
                    if (!imageType.test(this.files[0].type)) {
                        alert("不是图片")
                        //不是图片
                        //重新设置文件选择
                        //$("#imgFile").replaceWith("<input type=\"file\" name=\"image\" accept=\"image/*\" id=\"imgFile\"/>");
                        // $("#imgFile").removeAttr();
                        $("#spid").html("<input class=\"form-control\" id=\"user_image\" name=\"user_image\"  value=\"\" type=\"file\"/>");
                        //$("#imgFile").attr("accept","image/*");
                        //alert("替换了")

                        //刷新页面
                        //window.location.reload()
                        flag = false;
                    } else {
                        //alert("是图片")
                        //判断图片大小
                        var file_size = this.files[0].size;
                        if (file_size > 1024 * 1024) {
                            alert("您本次上传的图片超过1MB了,请选择一个小点的再上传.....");
                            flag = false;
                        } else {
                            //alert("没有超过")
                            //获取上传图片的路径
                            var url = null;
                            var imagePath = this.files[0]
                            //alert(imagePath)
                            if (window.createObjcectURL != undefined) {
                                url = window.createOjcectURL(imagePath);
                            } else if (window.URL != undefined) {
                                url = window.URL.createObjectURL(imagePath);
                            } else if (window.webkitURL != undefined) {

                                url = window.webkitURL.createObjectURL(imagePath);
                            }
                            //将当前图片展示到页面，进入预览
                            $("#preview").attr("src", url)
                            //src="C:\fakepath\day03_02.png"
                            flag = true;
                        }
                    }
                }
            } else {
                alert("您当前的版本太低，请更换高版本的浏览器")
                return flag = false;
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
                        <li><i class="fi ti-location-pin"></i>保定</li>
                        <li><i class="fi flaticon-email"></i> 111.163.cm</li>
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
                    <a class="navbar-brand" href="index.html"><img src="<%=request.getContextPath()%>/assets/images/logo-2.png" alt=""></a>
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
                </div>
                <!--各个跳转页面-->
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
            </div><!-- end of container -->
        </nav>
    </header>
    <!-- end of header -->
    <!-- start page-title -->
    <section class="page-title">
        <div class="container">
            <div class="row">
                <div class="col col-xs-12">
                    <h2>Blog</h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html" target="_blank">Home</a></li>
                        <li>Blog</li>
                    </ol>
                </div>
            </div> <!-- end row -->
        </div> <!-- end container -->
    </section>
    <!-- end page-title -->


    <!-- start wpo-blog-pg-section -->
    <section class="wpo-blog-pg-section blog-pg-left-sidebar section-padding">


        <!--侧边栏 end-->
        <!--主体-->
        <div class="container" style="width: 800px; height: 800px ; background-color: #ECFDF5; margin:auto">
            <div>

                <div class="row" style="border-bottom: #00686b 1px solid; text-align: center;">
                    <h3>基本信息</h3>
                    <span>(<i class="col-notice">*</i>为必须填写项)</span>
                </div>
                <div id="" style="text-align: center;">
                    <p class="col-hints">为了让各位DPer了解你，以下信息将显示在个人资料页。</p>
                    <legend style="text-align: center">用户的基本信息</legend>
                </div>


                <div class="container">
                    <div class="row">
                        <div class="col-md-12 ">
                            <form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/travelremark/userSetServlet.do?method=updateUser">
                                <!-- 表单区域-->
                                <fieldset>
                                    <!--表单主题-->
                                    <div class="profile-img" style="margin-left: 230px;">
                                        <img id="preview" src="${userMap.user_image}" alt=""> <br/>
                                    </div>

                                    <!-- 每一个form-group都可以自定义布局-->
                                    <div class="form-group">
                                        <!-- label表示文字提示标签,可以通过表单的组建的id提示-->
                                        <label class="col-md-2 control-label" >昵称</label>
                                        <div class="col-md-4">
                                            <input class="form-control" id="mid1" name="user_name" type="text" disabled="disabled" value="${userMap.user_name}"/>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-2 control-label" for="sex-woman">性别</label>
                                        <div class="col-md-5">
                                            <div class="radio-inline">
                                                <input type="radio" name="man" id="sex-man" value="" <c:if test="${userMap.user_sex!='女'}">checked</c:if>/>男
                                            </div>
                                            <div class="radio-inline">
                                                <input type="radio" name="woman" id="sex-woman" value="" <c:if test="${userMap.user_sex=='女'}">checked</c:if>/>女
                                            </div>
                                        </div>
                                    </div>
                                 <%--   <div class="form-group">
                                        <label class="col-md-2 control-label" for="lock">锁定状态</label>
                                        <div class="col-md-5">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" value="lock" name="city" id="lock"/>锁定
                                            </label>
                                        </div>
                                    </div>--%>
                                    <div class="form-group">
                                        <label class="control-label col-md-2" for="city">所在省份</label>
                                        <div class="col-md-4">
                                            <select id="city" name="user_city" class="form-control">
                                                <c:forEach items="${provinceList}" var="province">
                                                    <option value="${province.provinceId}"  <c:if test="${province.provinceName==userMap.user_city}">selected</c:if>>${province.provinceName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <!-- label表示文字提示标签,可以通过表单的组建的id提示-->
                                        <label class="col-md-2 control-label">自我介绍</label>
                                        <div class="col-md-4">
                                            <textarea name="user_introduce" style="width: 360px;height: 80px">${userMap.user_introduce}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <!-- label表示文字提示标签,可以通过表单的组建的id提示-->
                                        <label class="col-md-2 control-label">跟换头像</label>
                                        <label class="col-md-2 control-label" for="sex-man" id="spid"><input class="form-control" id="user_image" name="user_image"  accept="image/*" value="" type="file"/></label>
                                    </div>
                                    <div class="col-md-6 col-md-offset-3">
                                        <input id="que_but" class="btn btn-primary" type="submit" value="提交"/>
                                        <input class="btn btn-warning" type="reset" value="重置"/>
                                    </div>

                                </fieldset>
                            </form>
                        </div>
                    </div>
                    <div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!--主体 end-->

</section>
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

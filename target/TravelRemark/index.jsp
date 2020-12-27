<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <!-- Meta Tags -->
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
    <![endif]-->
    <script type="<%=request.getContextPath()%>/text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=CyuMQjRd8numjt8fQyFPLb684zTUzPgY"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
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

                       // $("#area").text();
                        var city = addComp.city;

                        $("#cityName").val(city)
                    });

                } else {
                    $(ev.currentTarget).text('定位失败');
                }
            })
            $("#tiao").click(function () {
//alert("点击了")
                var  cityName = $("#cityName").val();
                //alert(cityName)
                if (cityName == null || cityName.length == 0) {
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

                                $("#area").text();
                                var city = addComp.city;

                                //alert(city)
                                <%--  $.get("<%=request.getContextPath()%>/travelremark/remark/remarkServlet.do?method=findAllRemark", {city: city}, function () {

                                 }) --%>
                                //
                                location.href = encodeURI("<%=request.getContextPath()%>/homeServlet?city="+city);
                            });

                        } else {
                            $(ev.currentTarget).text('定位失败');
                        }
                    })
                }else {
                    location.href = encodeURI("<%=request.getContextPath()%>/homeServlet?city="+cityName);
                }


            })

        })

    </script>
</head>
<body>

<!-- main -->
<div class="w3layouts-main">
    <div class="bg-layer">
        <h1>旅途点评</h1>
        <div class="header-main">
            <div class="main-icon">
                <span class="fa fa-eercast"></span>
            </div>
            <div id="" style="color: darkorchid;text-align: center;font-size: 32px;">
             <%--   <a href="zhaohui.html">跳转到主页面</a>--%>
                <a  href="#" id="tiao">点击进入</a>
            </div>
            <input type="text" name="cityName" id="cityName" style="display: none">

        </div>
    </div>

</div>
</div>
<!-- //main -->

</body>

</html>

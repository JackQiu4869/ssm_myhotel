<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="fly-html-layui fly-html-store">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/layui/dist/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/css/global.css" charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/css/global(1).css" charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/css/store.css" charset="utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/statics/front/images/favicon.ico">
    <title>首页-酒店管理系统</title>
<body>
<!-- 顶部start -->
<div class="layui-header header header-store" style="background-color: #393D49;">
    <div class="layui-container">
        <a class="logo" href="index.jsp">
            <img src="${pageContext.request.contextPath}/statics/front/images/logo.png" alt="layui">
        </a>
        <div class="layui-form component" lay-filter="LAY-site-header-component"></div>
        <ul class="layui-nav" id="layui-nav-userinfo">
            <li data-id="index" class="layui-nav-item layui-hide-xs "><a class="fly-case-active" data-type="toTopNav"
                                                                                   href="/index.jsp">首页</a></li>
            <li data-id="room" class="layui-nav-item layui-hide-xs layui-this"><a class="fly-case-active"
                                                                       data-type="toTopNav"
                                                                       href="/bookRoom.jsp">房间</a></li>
            <li data-id="login" class="layui-nav-item layui-hide-xs "><a class="fly-case-active" data-type="toTopNav"
                                                                         href="/login.jsp">登入</a></li>
            <li data-id="register" class="layui-nav-item layui-hide-xs "><a class="fly-case-active" data-type="toTopNav"
                                                                            href="/register.jsp">注册</a></li>
            <span class="layui-nav-bar" style="left: 560px; top: 55px; width: 0px; opacity: 0;"></span></ul>
    </div>
</div>
<!-- 顶部end -->



<!-- 房间详情start -->
<div class="layui-container shopdata">
    <div class="layui-card shopdata-intro">
        <div class="layui-card-header">
				<span class="layui-breadcrumb layui-hide-xs" style="visibility: visible;">
				<a href="/index.jsp">首页</a><span lay-separator="">/</span>
						 <a><cite>房间详情</cite></a> </span>

        </div>
        <div class="layui-card-body layui-row">
            <div class="layui-col-md6">
                <div class="intro-img photos"> <img id="coverImg" src="http://qiniu.goodym.cn/950f5d78-d2a2-4e60-843a-60cbd0bd2651.jpg" alt="产品封面" layer-index="0"> </div>
            </div>
            <div class="layui-col-md6">
                <div class="intro-txt">
                    <h1 class="title" id="roomName">单人间</h1>
                    <input type="hidden" id="id" name="id" value="${sessionScope.loginUser.id}">
                    <div class="store-attrs">
                        <div class="summary">
                            <p class="reference"><span>房间号</span> <span id="roomNumber">100</span></p>
                            <p class="reference"><span>床　型</span> <span id="bedType">单人床</span></p>
                            <p class="reference"><span>标准价</span> ￥<span id="standardPrice">200</span></p>
                        </div>
                    </div>

                    <p class="store-detail-active" id="shopEvent">
                        <input type="hidden" id="currentId" value="${sessionScope.loginUser.id}">
                        <a href="javascript:;" id="bookRoomBtn" data-type="memberReserveHotel" class="store-bg-orange fly-memberReserveHotel">
                        <i class="layui-icon layui-icon-dollar"  ></i>立即预定 </a> </p>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-card shopdata-content">
        <div class="layui-card-body detail-body layui-text">
            <div class="layui-elem-quote"> <a href="/userComment.jsp">用户评价</a> </div>
            <div id="roomContent"><p><br></p>



            </div>
        </div>
    </div>
</div>
<!-- 房间详情end -->



<!-- 脚本开始 -->
<script src="${pageContext.request.contextPath}/statics/front/layui/dist/layui.js"></script>
<script>
    layui.use(["form","element","carousel",'jquery'], function () {
        var form = layui.form,
            layer = layui.layer,
            element = layui.element,
            carousel = layui.carousel,
            jquery=layui.jquery(),
            $ = layui.$;


        //渲染轮播图
        carousel.render({
            elem: '#LAY-store-banner'
            ,width: '100%' //设置容器宽度
            ,height: '460' //设置容器高度
            ,arrow: 'always' //始终显示箭头
        });


        //立即预定事件
        $("#bookRoomBtn").click(function (){
            var currentUser=$("#currentId").val();
            if (currentUser=="" ||currentUser.length==0){
                alert("您还没有登录");
            }else{
                alert("预定成功");
            }
        });

    });
</script>
<!-- 脚本结束 -->
<ul class="layui-fixbar">
    <li class="layui-icon layui-fixbar-top" lay-type="top" style=""></li>
</ul>
<div class="layui-layer-move"></div>

</body>
</html>
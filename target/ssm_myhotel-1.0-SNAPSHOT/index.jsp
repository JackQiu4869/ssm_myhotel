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
<%--<a id="quitRoom"></a>--%>
<%--<div >退出啊</div>--%>
<!-- 顶部start -->
<div class="layui-header header header-store" style="background-color: #393D49;">
    <div class="layui-container">
        <a class="logo" href="index.html">
            <img src="${pageContext.request.contextPath}/statics/front/images/logo.png" alt="layui">
        </a>

        <div class="layui-form component" lay-filter="LAY-site-header-component"></div>
        <ul class="layui-nav" id="layui-nav-userinfo">
            <li data-id="index" class="layui-nav-item layui-hide-xs layui-this"><a class="fly-case-active" data-type="toTopNav"
                                                                                   href="/index.jsp">首页</a></li>
            <li data-id="room" class="layui-nav-item layui-hide-xs "><a id="quitRoom" class="fly-case-active"
                                                                                  data-type="toTopNav"
                                                                                  href="javascript:;">退房</a></li>

            <li data-id="login" class="layui-nav-item layui-hide-xs "><a class="fly-case-active" data-type="toTopNav"
                                                                         href="/login.jsp">登入</a></li>
            <li data-id="register" class="layui-nav-item layui-hide-xs "><a class="fly-case-active" data-type="toTopNav"
                                                                            href="/register.jsp">注册</a></li>
            <span class="layui-nav-bar" style="left: 560px; top: 55px; width: 0px; opacity: 0;"></span></ul>

    </div>
</div>
<!-- 顶部end -->

<!-- 中间区域开始 -->
<div class="shop-nav shop-index">

    <div class="shop-banner">
        <input type="hidden" id="checkQuitRoom" name="id" value="${sessionScope.loginUser.id}">





        <!-- 酒店楼层开始 -->
        <div class="shop-temp" id="getIndexFloor">
            <div class="temp-hot">
                <div class="layui-container">
                    <div class="layui-row layui-col-space20">
                        <div data-id="1" class="layui-col-xs6 layui-col-md3">
                            <a class="template store-list-box fly-case-active" href="/bookRoom.jsp" data-type="toRoomInfo">
                                <img src="http://qiniu.goodym.cn/950f5d78-d2a2-4e60-843a-60cbd0bd2651.jpg" class="store-list-cover">
                                <h2 class="layui-elip">单人间</h2>
                                <p class="price"> <span title="金额"> ￥100 </span> <span title="房号" style="color:  #fff;background: #0e88cc;padding: 3px;text-align: center;border: 1px solid #4cffb3;font-size: 13px;"> NO.1 </span></p>
                            </a>
                        </div>
                        <div data-id="7" class="layui-col-xs6 layui-col-md3">
                            <a class="template store-list-box fly-case-active" href="JavaScript:void(0);" data-type="toRoomInfo">
                                <img src="http://qiniu.goodym.cn/47e28094-4ebf-40b3-9ea3-55f77c71c865.jpg" class="store-list-cover">
                                <h2 class="layui-elip">大床房</h2>
                                <p class="price"> <span title="金额"> ￥100 </span> <span title="房号" style="color:  #fff;background: #0e88cc;padding: 3px;text-align: center;border: 1px solid #4cffb3;font-size: 13px;"> NO.2 </span></p>
                            </a>
                        </div>
                        <div data-id="13" class="layui-col-xs6 layui-col-md3">
                            <a class="template store-list-box fly-case-active" href="JavaScript:void(0);" data-type="toRoomInfo">
                                <img src="http://qiniu.goodym.cn/acfae30b-e1d6-4d94-b7d4-fccba740fe62.jpg" class="store-list-cover">
                                <h2 class="layui-elip">总统房</h2>
                                <p class="price"> <span title="金额"> ￥200 </span> <span title="房号" style="color:  #fff;background: #0e88cc;padding: 3px;text-align: center;border: 1px solid #4cffb3;font-size: 13px;"> NO.3 </span></p>
                            </a>
                        </div>
                        <div data-id="19" class="layui-col-xs6 layui-col-md3">
                            <a class="template store-list-box fly-case-active" href="JavaScript:void(0);" data-type="toRoomInfo">
                                <img src="http://qiniu.goodym.cn/7e45a065-8ffa-4044-9ff4-4eeba5d4c6a4.jpg" class="store-list-cover">
                                <h2 class="layui-elip">豪华房</h2>
                                <p class="price"> <span title="金额"> ￥300 </span> <span title="房号" style="color:  #fff;background: #0e88cc;padding: 3px;text-align: center;border: 1px solid #4cffb3;font-size: 13px;"> NO.103 </span></p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- 酒店楼层结束 -->

    </div>
</div>
<!-- 中间区域结束 -->

<!-- 脚本开始 -->
<script src="${pageContext.request.contextPath}/statics/front/layui/dist/layui.js"></script>
<script>
    layui.use(["form","element","carousel",'layer'], function () {
        var form = layui.form,
            layer = layui.layer,
            element = layui.element,
            carousel = layui.carousel,
            $ = layui.$;

        //渲染轮播图
        carousel.render({
            elem: '#LAY-store-banner'
            ,width: '100%' //设置容器宽度
            ,height: '460' //设置容器高度
            ,arrow: 'always' //始终显示箭头
        });

        $("#quitRoom").click(function (){
            alert("????");
            var currentQuitUser=$("#checkQuitRoom").val();
            if (currentQuitUser==""||currentQuitUser.length==0){
                layer.alert("当前用户未登录");
            }else {
                $.post("/users/logOut",{"room_state":currentQuitUser},function (result){
                        layer.msg(result.message);//成功打印退房成功，失败打印用户未入住
                },"json");
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
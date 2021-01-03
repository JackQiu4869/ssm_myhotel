<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">



        <%-- 头部工具栏区域 --%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
            </div>
        </script>

        <!--表格-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table','layer'], function () {
        var $ = layui.jquery,
            form = layui.form,
            layer =layui.layer,
            table = layui.table;

        var tableIns=table.render({
            elem: '#currentTableId',
            url:'${pageContext.request.contextPath}/admin/myOrder/list',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {field: 'id', width: 120, title: '订单id',align:'center'},
                {field: 'username', width: 120, title: '用户名',align:'center'},
                {field: 'room_number', width: 120, title: '房间编号',align:'center'},
                {field: 'type', width: 120, title: '房间类型',align:'center'},
                {field: 'time_in',width:200, title: '入住时间',align:'center'},
                {field: 'time_number', width: 120, title: '入住天数',align:'center'},
                {field: 'phone', width: 120, title: '电话',align:'center'},
                {field: 'price', width: 120, title: '价格',align:'center'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            page: true,

        });



    });
</script>

</body>
</html>

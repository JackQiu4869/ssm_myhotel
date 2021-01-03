<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>评价管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <%-- 头部工具栏区域 --%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
            </div>
        </script>

        <!--表格-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <!--行工具栏区域-->
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">查看</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

        <%-- 点开修改窗口显示评论 --%>
        <div style="display: none;padding: 5px" id="addOrUpdateWindow">
            <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
                <div class="layui-form-item">
                    <label class="layui-form-label">评论内容</label>
                    <div class="layui-input-block">
                        <!--隐藏域-->
                        <input type="hidden" name="id">
                        <textarea name="comment_contain" class="layui-textarea" readonly="readonly" placeholder="评论信息"></textarea>

                    </div>
                </div>

                <div class="layui-form-item layui-row layui-col-xs12">
                    <div class="layui-input-block" style="text-align: center;">

                    </div>
                </div>
            </form>
        </div>

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
            url:'${pageContext.request.contextPath}/admin/comment/list',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {field: 'id', width: 120, title: '评论id',align:'center'},
                {field: 'room_type', width: 120, title: '房间类型',align:'center'},
                {field: 'name', width: 120, title: '姓名',align:'center'},
                {field: 'comment_contain', width: 120, title: '评论内容',align:'center'},

                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            page: true,

        });


        //toolbar监听事件
        var url;//提交地址
        var mainIndex;//窗口索引


        //查看与删除
        table.on('tool(currentTableFilter)', function (obj) {
            switch (obj.event){
                case "edit":
                    openUpdataWindow(obj.data);
                    break;
            }
        });

        //打开查看窗口
        function openUpdataWindow(data){
            mainIndex= layer.open({
                title: '查看评论',
                type: 1,//打开类型
                area: ['800px', '400px'],
                content: $("#addOrUpdateWindow"),
                success:function (){
                    //表单数据回显
                    form.val("dataFrm",data);//参数2：回显数据
                }
            });
        }





    });
</script>

</body>
</html>
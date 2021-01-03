<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>房型管理</title>
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
                            <label class="layui-form-label">房型名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

        <%-- 修改窗口 --%>
        <div style="display: none;padding: 5px" id="addOrUpdateWindow">
            <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
                <div class="layui-form-item">
                    <label class="layui-form-label">房型名</label>
                    <div class="layui-input-block">
                        <!--隐藏域-->
                        <input type="hidden" name="id">
                        <input type="text" name="name" lay-verify="required" autocomplete="off"
                               placeholder="请输入房型名" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-block">
                        <input type="text" name="price" lay-verify="required" autocomplete="off" placeholder="请输入价格"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-block">
                        <input type="text" name="my_states" lay-verify="required" autocomplete="off" placeholder="请输入房间状态"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-row layui-col-xs12">
                    <div class="layui-input-block" style="text-align: center;">
                        <button type="button" class="layui-btn" lay-submit lay-filter="doSubmit"><span
                                class="layui-icon layui-icon-add-1"></span>修改
                        </button>
                        <button type="reset" class="layui-btn layui-btn-warm"><span
                                class="layui-icon layui-icon-refresh-1"></span>重置
                        </button>
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
            table = layui.table,
             layer=layui.layer;

        var tableIns=table.render({
            elem: '#currentTableId',
            url:'${pageContext.request.contextPath}/admin/room/list',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {field: 'id', width: 120, title: '房型编号',align:'center'},
                {field: 'name', width: 120, title: '房型名称',align:'center'},
                {field: 'price', width: 120, title: '价格',align:'center'},
                {field: 'my_states', width: 120, title: '出售情况',align:'center'},

                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            page: true,

        });

        //toolbar监听事件
        var url;//提交地址
        var mainIndex;//窗口索引
       //监听修改与删除
        table.on('tool(currentTableFilter)',function (obj){
            switch (obj.event){
                case "edit":
                    openUpdateWindow(obj.data);
                    break;
                    case "delete":
                        deleteById(obj.data);
                        break;
            }
        });

            function openUpdateWindow(data){
                mainIndex= layer.open({
                    title: '修改房型',
                    type: 1,//打开类型
                    area: ['800px', '400px'],
                    content: $("#addOrUpdateWindow"),
                    success:function (){
                        //表单数据回显
                        form.val("dataFrm",data);//参数2：回显数据
                        url="/admin/room/updateRoomType"
                    }
                });
            }


        //监听表格提交事件
        form.on("submit(doSubmit)",function (data){
            $.post(url,data.field,function (result){
                if (result.success){
                    tableIns.reload();//刷新数据
                    layer.close(mainIndex);//关闭窗口
                }
                layer.msg(result.message);
            },"json");
            return false;
        });

        //删除房型
        function deleteById(data){
            layer.confirm("确定删除？",{icon: 3,title:"提示"},function (index){
                $.post("/admin/room/deleteById",{"id":data.id},function (result){
                    if (result.success){
                        tableIns.reload();//刷新表单
                    }
                    layer.msg(result.message);
                },"json");
                layer.close(index);
            });
        }




    });
</script>

</body>
</html>

<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>订票中心-车次管理</title>

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/echarts.min.js"></script>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="css/train.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    function yes(){
        var  makesure=confirm("确认要修改吗？");
        if(makesure==true)
        {return true;}
        return false;
    }    
</script>

</head>
<body>
<div class="top">
    <div class="toptitle">
    火车订票系统 Train Seat Reservation System
    </div>
    <div class="quit"><a type="button" class="btn btn-primary" href="file:///E:/web/train/login.html"><span class="glyphicon glyphicon-log-in"></span> 返回登录</a>
    </div>
</div>
<div class="left">
    <div class="choose">
        <a class="button button1"  href="index.jsp" role="button" style="padding-top:10%">基础查询</a><br>
        <a class="button button2"  href="search.jsp" role="button" style="padding-top:10%">高级查询</a><br>
        <a class="button button3"  href="usermanage.jsp" role="button" style="padding-top:10%">用户管理</a><br>
        <a class="button button3"  href="station.jsp" role="button" style="padding-top:10%">站点管理</a><br>
        <a class="button button3"  href="trainnumber.jsp" role="button" style="padding-top:10%">车次管理</a><br>
    </div>
</div>

<%--<div class="right">--%>
    <%--<div style=" height:420px;width:360px;margin-left: 60px;">--%>
        <%--<table class="table table-bordered table-condensed">--%>
        <%--<caption>车次信息</caption>--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>项目</th>--%>
            <%--<th>修改内容</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<tr>--%>
            <%--<td>车次名称</td>--%>
            <%--<td><input class="form-control" type = text id="trainId"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>起始站</td>--%>
            <%--<td><input class="form-control" type = text id="station" ></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>终点站</td>--%>
            <%--<td><input class="form-control" type = text id="endstation" ></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>发车时间</td>--%>
            <%--<td><input class="form-control" type = text id="detTime" ></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>到达时间</td>--%>
            <%--<td><input class="form-control" type = text id="arTime" ></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>票价</td>--%>
            <%--<td><input class="form-control" type = text id="price" ></td>--%>
        <%--</tr>--%>
        <%--</tbody>--%>
        <%--</table>--%>
        <%--<button type="button" type="submit"class="btn btn-success" onclick="yes()"><span class="glyphicon glyphicon-refresh"></span> 修改</button>--%>
    <%--</div>--%>
<%--</div>--%>

<div class="right">
    <div style="height:400px;width:270px;margin-top:20px;margin-left: 25%;">
        <form class="bs-example bs-example-form" name="outform" role="form" action="trainaction.action">
            <div class="input-group">
                <span class="input-group-addon">车次名称</span>
                <input type="text" class="form-control" name="trainId">
            </div><br>
            <div class="input-group">
                <span class="input-group-addon">起始站</span>
                <input type="text" class="form-control" name="from">
            </div><br>
            <div class="input-group">
                <span class="input-group-addon">终点站</span>
                <input type="text" class="form-control" name="to">
            </div><br>
            <div class="input-group">
                <span class="input-group-addon">发车时间</span>
                <div class="controls input-group date form_time col-md-15" data-date="" data-date-format="yyyy-mm-dd hh:ii" data-link-field="dtp_input3" data-link-format="yyyy-mm-dd-hh:ii">
                    <input class="form-control"  type="text" value="" id="" placeholder="请选择发车时间" name="arTime">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                </div>
                <input type="hidden" id="dtp_input3" value="" />
            </div><br>
            <div class="input-group">
                <span class="input-group-addon">到达时间</span>
                <div class="controls input-group date form_time col-md-15" data-date="" data-date-format="yyyy-mm-dd hh:ii" data-link-field="dtp_input3" data-link-format="yyyy-mm-dd-hh:ii">
                    <input class="form-control"  type="text" value="" id="" placeholder="请选择到达时间" name="deTime">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                </div>
                <input type="hidden" id="dtp_input3" value="" />
            </div><br>
            <div class="input-group">
                <span class="input-group-addon">票价</span>
                <input type="text" class="form-control" name="price">
            </div><br>
            <div class="input-group">
                <span class="input-group-addon">停靠站</span>
                <input type="text" class="form-control" name="stopstation">
            </div><br>
            <button type="submit" class="btn btn-info" onclick="yes()"><span class="  glyphicon glyphicon-search"></span> 修改</button>
        </form>
    </div>
</div>
<div class="footer">
    <div class="footfont">
    © 2017 Bootstrap Train Seat Reservation System. 杭州电子科技大学 - via team MAX
    </div>
</div>
<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd hh:ii",
        autoclose: true,
        todayBtn: true,
        startDate: "2013-02-14 10:00",
        minuteStep: 1
    });
</script>
<script type="text/javascript">

    $('.form_datetime').datetimepicker({
        //language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>

</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>订票中心-高级查询</title>

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/echarts.min.js"></script>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="css/table.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    function yes(){
        var  makesure=confirm("确认要查询吗？");
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
<div class="mid">
    <div style="height:400px;width:200px;margin-top:50px;margin-left: 30px;">
        <form class="bs-example bs-example-form" name="outform" role="form">      
        <div class="input-group">
            <span class="input-group-addon">出发地</span>
            <select class="form-control" name="station" >
            <option value="1">杭州</option>
            <option value="2">北京</option>
            <option value="3">上海</option>
            <option value="4">深圳</option>
            <option value="5">广州</option>
            </select>
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">目的地</span>
            <select class="form-control" name="endstation" >
            <option value="1">杭州</option>
            <option value="2">北京</option>
            <option value="3">上海</option>
            <option value="4">深圳</option>
            <option value="5">广州</option>
            </select>
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">时间</span>
            <div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                <input class="form-control"" type="text" value="" >
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
            <input type="hidden" id="dtp_input2" value="" /><br/>
        </div><br>
        <button type="submit" class="btn btn-info" onclick="yes()"><span class="  glyphicon glyphicon-search"></span> 查询最短路径</button><br><br>
        <button type="submit" class="btn btn-info" onclick="yes()"><span class="  glyphicon glyphicon-search"></span> 查询最便宜路径</button><br><br>
        <button type="submit" class="btn btn-info" onclick="yes()"><span class="  glyphicon glyphicon-search"></span> 查询中转站点</button><br>
        </form>
    </div>
</div>
<div class="right">
    <div class="category">
        <table class="table table-condensed table-bordered">
            <thead>
                <tr>
                    <th class="th1">车次</th>
                    <th class="th2">出发站</th>
                    <th class="th3">到达站</th>
                    <th class="th4">票价</th>
                    <th class="th5">出发时间</th>
                    <th class="th6">到达时间</th>
                    <th class="th7">距离</th>

                </tr>
            </thead>
        </table>   
    </div>
    <%--<div class="revise">--%>
        <%--<table class="table table-condensed table-bordered">--%>
            <%--<tbody>--%>
                <%--<tr>--%>
                    <%--<td class="td1">G1221</td>--%>
                    <%--<td class="td2">杭州</td>--%>
                    <%--<td class="td3">上海</td>--%>
                    <%--<td class="td4">17:40</td>--%>
                    <%--<td class="td5">19:00</td>--%>
                    <%--<td class="td6">1h20min</td>--%>
                    <%--<td class="td7">30元</td>--%>
                <%--</tr>--%>
            <%--</tbody>--%>
            <%--</table>--%>
    <%--</div>--%>
</div>
<div class="footer">
    <div class="footfont">
    © 2017 Bootstrap Train Seat Reservation System. 杭州电子科技大学 - via team MAX
    </div>

</div>

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
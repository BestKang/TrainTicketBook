﻿<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>订票中心-站点管理</title>

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/echarts.min.js"></script>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="css/station.css" rel="stylesheet" type="text/css" />

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

<div class="right">
    <div style="height:400px;width:270px;margin-top:60px;margin-left: 25%;">
    <form class="bs-example bs-example-form" name="outform" role="form" action="stationaction.action">
        <div class="input-group">
            <span class="input-group-addon">站点1</span>
            <select class="form-control" name="from" >
            <option value="杭州">杭州</option>
            <option value="北京">北京</option>
            <option value="上海">上海</option>
            <option value="嘉兴">嘉兴</option>
            <option value="广州">广州</option>
            </select>
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">站点2</span>
            <select class="form-control" name="to" >
            <option value="杭州">杭州</option>
            <option value="北京">北京</option>
            <option value="上海">上海</option>
            <option value="嘉兴">嘉兴</option>
            <option value="广州">广州</option>
            </select>
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">站点距离</span>
            <input type="text" class="form-control" name="distance">
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

</body>
</html>
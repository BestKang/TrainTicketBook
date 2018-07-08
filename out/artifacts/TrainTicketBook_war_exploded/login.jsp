<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>登录页面</title>

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/echarts.min.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link href="css/buttons.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    function check(f){
      if(f.user.value==""){
        alert("请输入用户名！");//弹出提示框
        f.user.focus();//文本框获取焦点
        return false;}
      if(f.pw.value==""){
        alert("请输入密码！");
        f.pw.focus();
        return false;}
      return false;
    }
</script>

</head>
<body>
<div class="top">
    <div class="toptitle">
    火车订票系统 Train Seat Reservation System
    </div>
</div>
<div class="load">
    <div class="loadpage">
        <h3>用户登录</h3><br>
        <form class="form-signin" onsubmit="return check(this)" action="loginaction.action">
            <div class="input-group">
                <input placeholder="用户名" id="userName" class="form-control" type = text name = "userName" />
            </div><br>
            <div class="input-group">
                <input placeholder="密码" id="userPw" class="form-control" type = password name = "userPw" />
            </div><br><br>
            <button class="button button-glow button-border button-rounded button-primary" type="submit" style="width: 78%;"><span>登录 </span></button><br>
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
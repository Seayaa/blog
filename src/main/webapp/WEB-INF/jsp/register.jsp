<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<link rel="icon" href="images/index/blog.png" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>blog</title>

<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap-switch.min.css">
<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrapValidator.min.css">

<base href="<%=basePath%>">

<style type="text/css">
	body{
		background:linear-gradient(to top, white, #0f3f61);
	}
	.top-div{
		width:100%;
		height:80px;
		border-bottom:1px solid #c9c9c9;
		background-color: white;
	}
	.home-link{
		float:right;
		font-size:20px;
		margin-right:25px;
		line-height: 80px;
	}
	.top-icon-div{
		float:left;
	}
	.middle-div{
		width: 80%;
		height:800px;
		margin:0 auto;
		padding-top:50px;
		position: relative;
		/* animation:animation1 1s ease-in; */
	}
	@keyframes animation1{
		0%{transform:scale(0) rotatey(0deg);}
		100%{transform:scale(1) rotatey(360deg);}
	}
	@keyframes animation2{
		0%{transform:translatey(5px)}
		100%{transform:translatey(-5px)}
	}
	.form-div{
		width: 45%;
		margin:0 auto;
		padding:50px 0px;
		background-color: #e4e4e4;
		margin-top:60px;
		border-radius: 30px/30px;
	}
	.form-horizontal .form-group{
		margin:0 auto;
	}
	.form-horizontal .form-group{
		margin-bottom:20px;
	}
	.form-horizontal .form-group input{
		height:40px;
	}
	.bootstrap-switch-id-sex{
		width:116px;
	}
	.birth-col{
		padding:0px;
		margin-right:10px;
	}
	label{
		font-size:18px;
	}
	h2{
		font-weight:600;
		font-size: 40px;
		font-style: italic;
		color:#009797;
		text-align: center;
		background:linear-gradient(to right,#808080, white, #a7a7a7);
		box-shadow: 6px 6px 15px 1px #d4d4d4;
		position: relative;
		animation:animation2 2s ease-in-out infinite alternate;
	}
</style>

<script type="text/javascript" src="static/plugins/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/plugins/bootstrap/js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="static/plugins/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/js/register.js"></script>
<script type="text/javascript">
	$(function(){
		$(".checkbox").bootstrapSwitch();
	});
	
</script>

</head>
<body>

	<div class="top-div">
		<div class="top-icon-div">
			<img src="images/index/blog.png" width="60px" height="60px" style="margin-top:10px;float:left;">
			<font style="line-height: 80px;font-size:30px;">blog</font>
		</div>
		<a class="home-link" href="index">首页</a>
	</div>
	<!-- top-div end -->
	
	<div class="middle-div">
		<h2>JOIN US...</h2>
		<div class="form-div">
			<form class="form-horizontal" id="register_form">
				<div class="form-group">
					<label class="control-label col-sm-3">账号：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">	
					</div>	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">昵称：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="nick_name" name="nick_name" placeholder="请输入昵称">
					</div>	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">密码：</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">确认密码：</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="password_conf" name="password_conf" placeholder="请再次输入密码">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">性别：</label>
					<div class="col-sm-8">
						<input type="checkbox" class="checkbox" name="sex" id="sex" data-on-text="男"
						data-off-text="女" checked>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">生日：</label>
					<div class="col-sm-8">
						<div class="col-sm-3 birth-col">
							<select class="form-control" id="year" name="year">
								<option value="2015">2015年</option>
								<option value="2010">2010年</option>
								<option value="2000">2000年</option>
								<option value="1995">1995年</option>	
							</select>
						</div>
						<div class="col-sm-3 birth-col">
							<select class="form-control" id="mon" name="mon">
								<option value="01">1月</option>
								<option value="02">2月</option>
								<option value="03">3月</option>
								<option value="04">4月</option>
								<option value="05">5月</option>
								<option value="06">6月</option>
								<option value="07">7月</option>
								<option value="08">8月</option>
								<option value="09">9月</option>
								<option value="10">10月</option>
								<option value="11">11月</option>
								<option value="12">12月</option>
							</select>
						</div>
						<div class="col-sm-3 birth-col">
							<select class="form-control" id="day" name="day">
								<option value="01">1日</option>
								<option value="05">5日</option>
								<option value="10">10日</option>
								<option value="15">15日</option>
								<option value="20">20日</option>
								<option value="25">25日</option>
								<option value="30">30日</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">地区：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="location" name="location" placeholder="请输入地区">
					</div>	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">介绍：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="introduction" name="introduction" placeholder="介绍一下自己吧">
					</div>	
				</div>
				<div class="form-group" style="text-align:center;">
					<div class="col-sm-8 col-sm-offset-3">
						<button type="submit" class="btn btn-primary">确认注册</button>
					</div>
				</div>
			</form>
		</div>
	
	</div>
	<!-- middle-div end -->
	
	<div class="bottom-div"></div>
	<!-- bottom-div end -->
</body>
</html>

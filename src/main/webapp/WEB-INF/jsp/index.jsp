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
<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrapValidator.min.css">


<base href="<%=basePath%>">
<style type="text/css">
	body{
		background-color: #f1f2f3;
		z-index:1000;
	}
	.top{
		width:80%;
		height:270px;
		margin:0 auto;
		background-color: #4e272c;
		min-width: 1000px;
	}
	.logo-div{
		width:40%;
		height:130px;
		margin:0 auto;
		position:relative;
		top:40px;
		text-align: center;
	}
	#right-div{
		width:130px;
		height:35px;
		float:right;
		text-align: center;
		padding:5px;
	}
	.right-link{
		font-size:18px;
	}
	.right-link:link{
		color:#a8bfca;
		text-decoration: none;
	}
	.right-link:visited{
		color:#a8bfca;	
		text-decoration: none;
	}
	.right-link:hover{
		color:#7f945c;	
		text-decoration: underline;
	}
	.right-link:active{
		color:black;	
		text-decoration: none;
	}
	#bottom-div{
		width:100%;
		height:60px;
		position: relative;
		top:35px;
		margin-top:30px;
	}
	.nav-div{
		width:60%;
		height:inherit;
		margin-left:20px;
	}
	.search-div{
		width: 40%;
		height: inherit;
		position:relative;
		top:-60px;
		left:60%;
	}
	.breadcrumb{
		position:relative;
		top:10px;
		margin-bottom:0px;
		font-size:20px;
		background-color: inherit;
	}
	.search-part{
		width:450px;
		height:60px;
		background-color: inherit;
		margin-right:10px;
		float:right;
	}
	.search-input{
		width: 80%;
		height: 80%;
		border:1px solid #d9d5d5b3;
		border-radius:20px/20px;
		padding-left:20px;
		font-size:20px;
		margin:6px 10px;
		outline:none;
		background-color:#fcfcfc;
		box-shadow：none;
		transition:box-shadow 0.4s ease;
	}
	.search-icon{
		width:48px;
		height:80%;
		border:1px solid silver;
		float:right;
		margin:6px 20px 0 0 ;
		background-color:#fcfcfc;
		border-radius:20px/20px;
		text-align: center;
		padding-top:14px;
	}
	.search-input:hover{
		box-shadow:0px 0px 14px 3px #c20200;
	}
	.search-icon:hover{
		cursor: pointer;
	}
	.search-icon:active{
		background-color: #c6c6c6;
	}
	.main{
		width:80%;
		min-width: 1000px;
		margin:0 auto;
		display: flex;
	}
	.left-main{
		width:20%;
		height:100px;
		margin-right: 10px;
		opacity: 0.4;
		border-radius:10px/10px;
		background-color: grey;
		
	}
	.mid-main{
		width:60%;
		height:600px;
		border-radius:10px/10px;
		margin-right: 10px;
		background-color: white;
	}
	.right-main{
		width: 20%;
		height:500px;
		opacity: 0.4;
		border-radius:10px/10px;
		background-color: grey;
	}
	.cover_div{
		width: 100%;
		height: 100%;
		min-height:1000px;
		min-width:1000px;
		padding:0px;
		background-color: black;
		opacity: 0.65;
		position: absolute;
		top:0px;
		left:0px;
		z-index:1200;
		display: none;
	}
	.blur{
		-webkit-filter:blur(10px);
	}
	.login_div{
		width: 25%;
		position:absolute;
		top:200px;
		left:37.5%;
		z-index:1200;
		background:linear-gradient(#21435b, #5f7481,#133a4f);
		min-width: 600px;
		border-radius: 25px 25px;
		display: none;
	}
	#login_form{
		width:60%;
		height:400px;
		margin:0 auto;
		margin-top:60px;
		margin-bottom:80px;
		text-align: center;
	}
	#login_form input{
		height:55px;
		font-size:20px;
	}
	#login_form .glyphicon{
		font-size:20px;
	}
	#login_form .input-group-addon{
		padding:15px;
	}
	.form-group-lg{
		margin-bottom: 27px;
	}
	.close_login{
		cursor: pointer;
		position: absolute;
		top:0px;
		right: 0px;
		transform:none;
		tansition: transform 2s ease;
	}
	h3{
		text-align:center;
		border-bottom:1px solid #cdcdcd;
		padding: 18px;
		font-size: 26px;
		height:65px;
		color:#000000a6;
		margin:0;
		background-position:10%;
		background:linear-gradient(to right,#929292, #dedede, #929292);
		letter-spacing: 10px;
	}
	@keyframes slideIn{
		0%{transform:translatey(-250px)}
		30%{transform:translatey(50px)}
		50%{transform:translatey(-40px)}
		70%{transform:translatey(35px)}
		80%{transform:translatey(-15px)}
		90%{transform:translatey(10px)}
		100%{transform:translatey(0px)}
	}
	@keyframes slideOut{
		0%{transform:translatey(0px)}
		20%{transform:translatey(20px)}
		100%{transform:translatey(-250px)}
	}
	.slideIn{
		animation:slideIn 1s ease-in-out forwards;
	}
	.slideOut{
		animation: slideOut 2s ease;
	}
	#loginConfirm_btn{
		width:100%;
		height:55px;
		background-color: #77c7d7;
		font-size: 20px;
		letter-spacing: 10px;
		font-weight: 600;
		font-family: 'STXihei';
	}
	#loginConfirm_btn:hover{
		background-color:#5bbad0f5 ;
	}
	.close_login:hover{
		transform:scale(1.2,1.2);
	}
	.in_group .bv-no-label{
		top:10px;
	}
	.code_input .bv-no-label{
		top: 6px;
	}
	.form-horizontal .has-feedback .form-control-feedback{
		right:10px;
	}
</style>

<script type="text/javascript" src="static/plugins/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/plugins/bootstrap/js/bootstrapValidator.min.js"></script>

<script type="text/javascript" src="static/js/login.js"></script>

</head>

<body>
	<div class="blur_div">
		<div class="top">
			<div id="right-div">
				<a class="right-link" href="javascript:void(0)" id="login_btn">登录</a>
				<font class="right-link">/</font>
				<a class="right-link" href="register">注册</a>
			</div>
			<div class="logo-div">
				<img src="images/index/blog.png">
				<font style="font-size:65px;color:cadetblue;position:relative;top:30px;letter-spacing: 35px;font-weight:600;">log</font>
			</div>
			<div id="bottom-div">
				<div class="nav-div">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="#">News</a></li>
						<li><a href="#">Search</a></li>
					</ol>
				</div>
				<div class="search-div">
					<div class="search-part">
						<input type="text" id="searchValue" class="search-input" placeholder="Search...">
						<div class="search-icon"><i class="glyphicon glyphicon-search" style="font-size:20px;"></i></div>
					</div>
				</div>
			</div>
		</div>
		<!-- top end -->
		<div class="main">
			<div class="left-main">
			</div>
			<div class="mid-main"></div>
			<div class="right-main"></div>
		</div>
		<!-- main end -->
		<div class="foot"></div>
		<!-- foot end -->
	</div>
	
	
	<!-- cover -->
	<div class="cover_div">	
	</div>
	
	<!-- login_window -->
	<div class="login_div slideIn">
		<div class="close_login" title="关闭">
			<img src="images/index/remove-sign.png" width="40px" height="40px">
		</div>
		
		<h3>登录</h3>
		
		<form class="form-horizontal" id="login_form">
			<div class="form-group form-group-lg in_group">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					<input type="text" class="form-control" id="account" name="account" placeholder="账号">
				</div>
			</div>
			<div class="form-group form-group-lg in_group">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
					<input type="password" class="form-control" id="password" name="password" placeholder="密码">	
				</div>
			</div>
			<div class="form-group form-group-lg">
				<div class="col-sm-6 code_input" style="padding:0px;">
					<input type="text" class="form-control" id="code" name="code" placeholder="验证码">
				</div>
				<div class="col-sm-6" style="padding:0px;text-align: right;">
					<img src="getCodeImg" id="codeImg" style="height:40px;margin:12px 15px 0 0;">
					<a href="javascript:void(0)" id="change_code" style="font-size: 18px;color:#00ec58;text-decoration: underline;" title="换一换">
						<i class="glyphicon glyphicon-refresh" style="top:15px;"></i></a>
				</div>
				
			</div>
			<div class="form-group form-group-lg">
				<button type="submit" class="btn" id="loginConfirm_btn">登录</button>	
			</div>
			<a href="register" style="font-size: 22px;color:#b0d1ee;">立即注册>></a>
		</form>
	</div>
	<!-- login_window end -->
</body>
</html>
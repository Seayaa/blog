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
<title>Blog</title>

<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css">


<base href="<%=basePath%>">

<script type="text/javascript" src="static/plugins/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/js/chat.js"></script>

<style type="text/css">
	.chat_div{
		width: 1000px;
		height: 1000px;
		text-align: center;
		padding-top: 20px;
		background-color: #f7f7f7;
		box-shadow: 0px 0px 5px 5px #aeaeae;
		outline: 10px ridge#d5dcde;
		margin-top:40px;
		margin-left:60px;
	}
	.left_div{
		width:230px;
		height: 800px;
		margin-left:20px;
		border:1px solid #cdcdcd;
		padding:10px 5px;
		background-color: white;
	}
	.right_div{
		width: 700px;
		height: 800px;
		position: relative;
		margin:0px 20px;
		top:-800px;
		left:250px;
	}
	#send_btn{
		width:100px;
		margin-top:15px;
	}
	.user_div:hover{
		cursor: pointer;
	}
	.user_div{
		width:90%;
		height: 40px;
		background-color: #eef9fe; 
		text-align: center; 
		line-height: 40px;
		font-size:25px;
		margin-bottom:15px;
		float:right;
		border:1px solid #3f91d045;
	}
	.show_div{
		width: 100%;
		height:550px; 
		border:1px solid #c8c6c6; 
		border-radius:5px/5px; 
		overflow:auto ;
		margin-bottom:20px;
		position: absolute;
		z-index: -1;
		top:0px;
		left:0px;
		background-color: white;
		padding:8px 10px;
		box-shadow: 0px 0px 5px 5px #d1d1d1;
	}
	.text_div{
		width: 100%;
		height: 230px;
		position: absolute;
		top:580px;
		left:0px;
	}
	.active{
		box-shadow: 0px 0px 5px 5px #989898;
	}
	.send_line{
		text-align: left;
		padding-right:10px;
		width: 100%;
		height: 40px;
		line-height: 40px;
		font-size:20px;
		margin-bottom:10px;
	}
	.self_line{
		text-align: right;
		padding-left:10px;
		width: 100%;
		height: 40px;
		font-size: 20px;
		line-height: 40px;
		margin-bottom:10px;
	}
	.self_font{
		background-color:#9ed0ea;
		display:inline-block;
		padding:0px 10px;
		border-radius:10px/10px;
	}
	.send_font{
		background-color:#e9e9e9;
		display:inline-block;
		padding:0px 10px;
		border-radius:10px/10px;
	}
	.self_user, .send_user{
		display: inline-block;
		background-color: #ecdce0;
		border-radius: 50%;
		padding:0 10px;
	}
	.self_user{
		margin-left:10px;
	}
	.send_user{
		margin-right:10px;
	}
</style>
</head>
<body>

	<div class="chat_div">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-3 control-label" id="userName_label">请输入昵称:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="userName" placeholder="NickName">
				</div>
			</div>
			<button type="button" class="btn btn-primary" id="connect_btn">确认登录</button>
		</form>
		<hr style="height: 10px; background:linear-gradient(to right, #a23a3a,#8fa795,#4949ab);">
		<div class="left_div">
			
		</div>
		
		<div class="right_div">
			
			<div class="text_div">
				<textarea rows="5" class="form-control" style="resize:none;overflow: hidden;font-size:20px;" id="text"></textarea>
				<button type="button" class="btn btn-primary" id="send_btn">发送</button>
			</div>
		</div>
	</div>
</body>
</html>
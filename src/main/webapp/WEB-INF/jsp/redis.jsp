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
<title>redis</title>

<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrapValidator.min.css">
<script type="text/javascript" src="static/plugins/jquery/jquery-3.2.1.min.js"></script>

<base href="<%=basePath%>">
</head>
<body>

	<div>
		<form method="get" action="set">
			<div class="form-group">
			  <label>key:</label>
			  <input type="text" class="form-control" name="key" placeholder="key">
			</div>
			<div class="form-group">
			  <label>value:</label>
			  <input type="text" class="form-control" name="value" placeholder="value">
			</div>
			<div class="form-group">
			  <label>duration:</label>
			  <input type="number" class="form-control" name="duration" value="0">
			</div>
			<div class="form-group">
			  <button type="submit" class="btn btn-default">确认</button>
			</div>
		</form>
		
		<form method="get">
			<div class="form-group">
			  <label>key:</label>
			  <input type="text" class="form-control" name="key" placeholder="key" id="key">
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-default" onclick="get()">确认</button>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" readonly="readonly" id="value">
			</div>
		</form>
		
		
		<form method="get" action="setObj">
			<div class="form-group">
			  <label>key:</label>
			  <input type="text" class="form-control" name="key" placeholder="key">
			</div>
			
			<div class="form-group">
				<label>name:</label>
				<input type="text" class="form-control" name="name">
			</div>
			<div class="form-group">
				<label>age:</label>
				<input type="text" class="form-control" name="age">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">确认</button>
			</div>
		</form>
		
		<form method="get">
			<div class="form-group">
			  <label>key:</label>
			  <input type="text" class="form-control" name="key" placeholder="key" id="key_1">
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-default" onclick="get_1()">确认</button>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" readonly="readonly" id="value_1">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function get() {
			$.getJSON("get", {key:$("#key").val()}, function(data){
				$("#value").val(data.res);
			})
		}
		function get_1(){
			$.getJSON("getObj",{key:$("#key_1").val()}, function(data){
				$("#value_1").val(data.res)
			})
		}
	
	
	</script>
</body>
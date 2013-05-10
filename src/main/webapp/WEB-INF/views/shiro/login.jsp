<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Apache Shiro Auth</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<jsp:include page="../../../bootstrap/inc.jsp"></jsp:include>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="${pageContext.request.contextPath }/bootstrap/js/html5shiv.js"></script>
<![endif]-->

<style>
body {
	padding-top: 80px;
	padding-bottom: 40px;
}
</style>
</head>
<body onload='document.f.username.focus();'>

	<div class="navbar navbar-inverse navbar-fixed-top">
	  <div class="navbar-inner">
	    <div class="container">
	      <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </a>
	      <a href="#" class="brand"><strong>maven-framework-project</strong></a>
	      <div class="nav-collapse">
	        <ul class="nav">
	          <li class="active"><a href="#">首页</a></li>
	          <li><a href="#about">关于</a></li>
	          <li><a href="#contact">联系</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
	</div>
  	
	<div class="container-fluid" >
		<form name='f' action="${pageContext.request.contextPath}/shiro/login.do" method='POST' class="form-horizontal">
		<fieldset>
			<legend><h2>Apache Shiro Auth</h2></legend>
		${msg }
			<c:if test="${!empty shiroLoginFailure}">
				<div class="alert alert-error alert-block controls">
					<button class="close" data-dismiss="alert">×</button>${username } ${shiroLoginFailure }
				</div>
			</c:if>
		
		<div class="control-group">
			<label for="username" class="control-label">用户名:</label>
			<div class="controls">
				<input type='text' name='username'  placeholder="用户名" id="username" class="input-large required" minlength="3"/>
			</div>
		</div>
		<div class="control-group">
			<label for="password" class="control-label">密码:</label>
			<div class="controls">
				<input type='password' name='password' placeholder="密码" id="password" class="input-large required"/>
			</div>
		</div>
		<div class="control-group">
			<label for="confirmPassword" class="control-label">验证码:</label>
			<div class="controls">
				<input type='text' name='captcha_key' placeholder="验证码" id="captcha_key" class="input-large required"/>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
		        <label class="checkbox">
		          <input type="checkbox" id="rememberMe" name="rememberMe"/>记住我
		        </label>
		        	<img src="${pageContext.request.contextPath}/jcaptcha.jpg" title="看不清楚换一张"  id="captcha" />
				</div>
			</div>
			<div class="form-actions">
				<button class="btn btn-large btn-primary" type="submit">确定</button>
		 	   	<button class="btn btn-large" type="reset">取消</button>
			</div>
		</fieldset>
		<div class="control-group" style="text-align: center;">
			<span class="help-block">(管理员: <b>user1/user1</b>, 普通用户: <b>user2/user2</b>)</span>
		</div>
		</form>
	</div>

	
	<footer>
		<div class="container-fluid">
			<hr/>
			<p align="center">&copy; maven-framework-project 2012</p>
		</div>
	</footer>
</body>
</html>
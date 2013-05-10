<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	padding-top: 40px;
	padding-bottom: 40px;
}
#login-box{
	width: 450px;
	margin: 0 auto;
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
	       <p class="navbar-text pull-right">
		   		<shiro:authenticated>
		   			<shiro:principal/>
		   			<shiro:hasRole name="Admin">管理员</shiro:hasRole>
		   			<shiro:hasRole name="User">普通用户</shiro:hasRole>
		   			<shiro:hasPermission name="user:edit">编辑</shiro:hasPermission>
		   			<shiro:hasPermission name="user:view">查看</shiro:hasPermission>
		   			<a href="${pageContext.request.contextPath }/logout">退出</a>
		   		</shiro:authenticated>
		   		
		   		<shiro:notAuthenticated>
		   			<a href="${pageContext.request.contextPath }/shiro/login.do">登录</a>
		   		</shiro:notAuthenticated>
		   		
		   </p>
	        <ul class="nav">
	          <li class="active"><a href="#">首页</a></li>
	          <li><a href="#about">关于</a></li>
	          <li><a href="#contact">联系</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
	</div>
  	
  	
  	<div class="container" style="width: 960px; margin: 0 auto;">
	 	
	 	<div class="page-header">
	 		<h3>Apache Shiro Auth</h3>
			<c:if test="${!empty shiroLoginFailure}">
				<div class="alert alert-error alert-block controls">
					<button class="close" data-dismiss="alert">×</button>${username } ${shiroLoginFailure }
				</div>
			</c:if>
		</div>
	 	
	 	<div id="login-box">
	 		<form name='f' action="${pageContext.request.contextPath}/shiro/login.do" method='POST' class="form-horizontal">
				 <fieldset>
				    <div class="control-group">
				      <label class="control-label" for="username">您的用户名</label>
				      <div class="controls">
				        <input type='text' name='username'  placeholder="用户名" id="username" class="input-medium" minlength="3"/>
				        <p class="help-block">字母，数字，汉字皆可</p>
				      </div>
				    </div>
				    <div class="control-group">
				      <label class="control-label" for="password">您的密码</label>
				      <div class="controls">
				        <input type='password' name='password' placeholder="密码" id="password" class="input-medium"/>
				        <p class="help-block">请输入您的密码</p>
				      </div>
				    </div>
				    
				    <div class="control-group">
				      <label class="control-label" for="captcha_key">您的验证码</label>
				      <div class="controls">
				        <input type='text' name='captcha_key' placeholder="验证码" id="captcha_key" class="input-medium"/>
				        <img src="${pageContext.request.contextPath}/jcaptcha.jpg" title="看不清楚换一张"  id="captcha" />
				        <p class="help-block">请输入验证码</p>
				      </div>
				    </div>
				    
				    <div class="control-group">
				      <div class="controls">
				        <label class="checkbox">
		    					<input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我
		  				</label>
				      </div>
				    </div>
				    
				    <div class="control-group">
					    <div class="controls">
							<button class="btn btn-primary" type="submit">确定</button>
    						<button class="btn" type="reset">取消</button>
				      	</div>
			      	</div>
			      	
				  </fieldset>
				  <div class="control-group" align="center">
					<span class="help-block">(管理员: <b>admin/admin</b>, 普通用户: <b>user/user</b>)</span>
				  </div>
			</form>
	 	</div>
		
	</div> <!-- /container -->
	
	<footer>
		<div class="container-fluid">
			<hr/>
			<p align="center">&copy; maven-framework-project 2012</p>
		</div>
	</footer>
</body>
</html>
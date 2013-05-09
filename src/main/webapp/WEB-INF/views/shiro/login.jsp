<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.UnknownAccountException"%>
<%@ page import="org.apache.shiro.authc.AccountException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ page import="com.fengjing.framework.shiro.IncorrectCaptchaException"%>
<%@ page import="org.apache.shiro.authc.AuthenticationException"%>
<%@ page import="org.apache.shiro.authc.DisabledAccountException"%>
<%@ page import="org.springside.modules.utils.Exceptions"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Spring Security Login</title>
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
  	padding-top: 60px;
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
	 		<h3>Apache Shiro Login with Username and Password</h3>
		</div>
			 	
	 	<div id="login-box">
	 		<form name='f' action="${pageContext.request.contextPath}/shiro/login.do" method='POST' class="form-horizontal">
				<%
				String errorString = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
				if(errorString != null){
					
					Class error = null;
					try {
						error = Class.forName(errorString);
					} catch (ClassNotFoundException e) {
					} 
					
					String msg = "其他错误！";
					if (error != null) {
						if (error.equals(AccountException.class))
							msg = "未知帐号错误！";
						else if (error.equals(UnknownAccountException.class))
							msg = "未知帐号错误！";
						else if (error.equals(IncorrectCredentialsException.class))
							msg = "密码错误！";
						else if (error.equals(IncorrectCaptchaException.class))
							msg = "验证码错误！";
						else if (error.equals(AuthenticationException.class))
							msg = "认证失败！";
						else if (error.equals(DisabledAccountException.class))
							msg = "账号被冻结！";
					}
				%>
				<div class="alert alert-error input-medium controls">
					<button class="close" data-dismiss="alert">×</button>登录失败，<%=msg %>
				</div>
				<%
				}
				%>
				 <fieldset>
				 
				    <div class="control-group">
				      <label class="control-label" for="username">您的用户名</label>
				      <div class="controls">
				        <input type='text' name='username'  placeholder="用户名" id="username" class="input-medium search-query">
				        <p class="help-block">字母，数字，汉字皆可</p>
				      </div>
				    </div>
				    <div class="control-group">
				      <label class="control-label" for="password">您的密码</label>
				      <div class="controls">
				        <input type='password' name='password' placeholder="密码" id="password" class="input-medium search-query"/>
				        <p class="help-block">请输入您的密码</p>
				      </div>
				    </div>
				    
				    <div class="control-group">
				      <label class="control-label" for="captcha_key">验证码</label>
				      <div class="controls">
				        <input type='text' name='captcha_key' placeholder="验证码" id="captcha_key" class="input-medium search-query"/>
				        <img src="${pageContext.request.contextPath}/jcaptcha.jpg" alt="点击刷新验证码" width="75" height="24" id="captcha"/>
				        <p class="help-block">请输入验证码</p>
				      </div>
				    </div>
				    
				    <div class="control-group">
				      <div class="controls">
				        <label class="checkbox">
		    					<input type="checkbox" id="rememberMe" name="rememberMe"/>记住我
		  				</label>
				      </div>
				    </div>
				    
				    <div class="control-group">
					    <div class="controls">
							<button class="btn btn-primary" type="submit">确定</button>
    						<button class="btn" type="reset">取消</button>
				      	</div>
			      	</div>
			      	
			      	<div class="control-group" style="text-align: center;">
					   <span class="help-block">(管理员: <b>user1/user1</b>, 普通用户: <b>user2/user2</b>)</span>
			      	</div>
			      	
				  </fieldset>
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
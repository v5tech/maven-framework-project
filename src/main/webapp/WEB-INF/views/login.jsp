<%@ page contentType="text/html; charset=utf-8" %>
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

<jsp:include page="../../bootstrap/inc.jsp"></jsp:include>

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
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>

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
	 		<h3>Spring Security Login with Username and Password (Custom Page)</h3>
			<c:if test="${not empty error}">
				<div class="errorblock lead">
					Your login attempt was not successful, try again.<br /> Caused :
					${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
				</div>
			</c:if>
		</div>
	 	
	 	<div id="login-box">
	 		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST' class="form-horizontal">
			
				 <fieldset>
				    <div class="control-group">
				      <label class="control-label" for="j_username">您的用户名</label>
				      <div class="controls">
				        <input type='text' name='j_username' value="<sec:authentication property="name"/>" placeholder="用户名" id="j_username" class="input-medium search-query">
				        <p class="help-block">字母，数字，汉字皆可</p>
				      </div>
				    </div>
				    <div class="control-group">
				      <label class="control-label" for="j_password">您的密码</label>
				      <div class="controls">
				        <input type='password' name='j_password' placeholder="密码" id="j_password" class="input-medium search-query"/>
				        <p class="help-block">请输入您的密码</p>
				      </div>
				    </div>
				    
				    <div class="control-group">
				      <div class="controls">
				        <label class="checkbox">
		    					<input type="checkbox" name="_spring_security_remember_me"/>两周之内不必登陆
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
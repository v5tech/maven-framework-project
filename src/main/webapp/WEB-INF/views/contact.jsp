<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Spring 3 MVC Series - Contact Manager</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
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

.form-actions{
	background-color: #FFFFFF;
}
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.infomation{
	height: 12px;
	line-height: 12px;
	padding-top: 10px;
	padding-left: 20px;
}

</style>
</head>
<body>

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

<div class="container" style="width: 960px;margin: 0 auto;">
	
	<div class="hero-unit infomation">
		<h2>Spring MVC Contact Manager</h2>
	</div>

	<form:form method="post" action="${pageContext.request.contextPath }/add.do" commandName="model" cssClass="form-horizontal">
	 	<form:errors path="*" cssClass="errorblock" element="div" />
	 	<fieldset>
			<legend>注册</legend>
				<div class="control-group">
					<label class="control-label" for="firstname">firstname</label>
					<div class="controls">
						<form:input path="firstname" cssClass="input-xlarge focused" id="firstname"/>
						<span class="help-inline"><form:errors path="firstname" cssClass="error"/></span>
						<p class="help-block">字母皆可</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="lastname">lastname</label>
					<div class="controls">
						<form:input path="lastname" cssClass="input-xlarge" id="lastname"/>
						<span class="help-inline"><form:errors path="lastname" cssClass="error"/></span>
						<p class="help-block">字母皆可</p>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="email">email</label>
					<div class="controls">
						<form:input path="email" cssClass="input-xlarge" id="email"/>
						<span class="help-inline"><form:errors path="email" cssClass="error"/></span>
						<p class="help-block">合法的电子邮件地址</p>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="age">age</label>
					<div class="controls">
						<form:input path="age" cssClass="input-xlarge" id="age"/>
						<span class="help-inline"><form:errors path="age" cssClass="error"/></span>
						<p class="help-block">数字皆可,年龄只能在1到150之间</p>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="telephone">telephone</label>
					<div class="controls">
						<form:input path="telephone" cssClass="input-xlarge" id="telephone"/>
						<span class="help-inline"><form:errors path="telephone" cssClass="error"/></span>
						<p class="help-block">电话号码只能为数字,且不能超过11位!(010-8805784)</p>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="qq">QQ</label>
					<div class="controls">
						<form:input path="qq" cssClass="input-xlarge" id="qq"/>
						<span class="help-inline"><form:errors path="qq" cssClass="error"/></span>
						<p class="help-block">QQ号只能为数字</p>
					</div>
				</div>
				<div class="form-actions">
		            <button class="btn btn-primary" type="submit">保存</button>
		            <button class="btn" type="reset">重置</button>
	            </div>
		</fieldset>
		<!--  
	 	<table>
		    <tr>
		        <td><form:label path="firstname">First Name</form:label></td>
		        <td><form:input path="firstname" /></td> 
		        <td><form:errors path="firstname" cssClass="error"/></td> 
		    </tr>
		    <tr>
		        <td><form:label path="lastname">Last Name</form:label></td>
		        <td><form:input path="lastname" /></td>
		        <td><form:errors path="lastname" cssClass="error"/></td> 
		    </tr>
		    <tr>
		        <td><form:label path="email">Email</form:label></td>
		        <td><form:input path="email" /></td>
		        <td><form:errors path="email" cssClass="error"/></td> 
		    </tr>
		    <tr>
		        <td><form:label path="age">age</form:label></td>
		        <td><form:input path="age" /></td>
		        <td><form:errors path="age" cssClass="error"/></td> 
		    </tr>
		    <tr>
		        <td><form:label path="telephone">Telephone</form:label></td>
		        <td><form:input path="telephone" /></td>
		        <td><form:errors path="telephone" cssClass="error"/></td> 
		    </tr>
		    <tr>
		        <td><form:label path="qq">QQ</form:label></td>
		        <td><form:input path="qq" /></td>
		        <td><form:errors path="qq" cssClass="error"/></td> 
		    </tr>
		    <tr>
		        <td colspan="2">
		          <button class="btn btn-primary" type="submit">Add Contact</button>
		        </td>
		    </tr>
		</table>
	    -->
	</form:form>

</div>

<footer>
	<div class="container-fluid">
		<hr/>
		<p align="center">&copy; maven-framework-project 2012</p>
	</div>
</footer>

</body>
</html>
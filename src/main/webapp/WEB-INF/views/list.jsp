<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
<style type="text/css">

body {
	padding-top: 60px;
	padding-bottom: 40px;
}  

.table th,.table td {
 	text-align: center;
}
.pager{
	margin: 0;
}
.pageinfo-view{
	height:25px;
	line-height: 25px;
}
.infomation{
	height: 12px;
	line-height: 12px;
	padding-top: 2px;
	padding-left: 10px;
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
	
	<div>
		<table class="table table-hover table-striped table-bordered">
		<thead>
			<th>Id</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>telephone</th>
			<th>age</th>
			<th>email</th>
			<th>qq</th>
			<th>操作</th>
		</thead>
		<c:forEach var="contact" items="${alllist}">
		<tr>
			<td><c:out value="${contact.id }"></c:out></td>
			<td><c:out value="${contact.firstname }"></c:out></td>
			<td><c:out value="${contact.lastname }"></c:out></td>
			<td><c:out value="${contact.telephone }"></c:out></td>
			<td><c:out value="${contact.age }"></c:out></td>
			<td><c:out value="${contact.email }"></c:out></td>
			<td><c:out value="${contact.qq }"></c:out></td>
			<td>
				<a href="${pageContext.request.contextPath }/npage.do">新增</a>
				<a href="${pageContext.request.contextPath }/modify/${contact.id }.do">修改</a>
				<a href="${pageContext.request.contextPath }/del/${contact.id }.do">删除</a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>
	
	
	
	<div class="row-fluid">
		
		<div class="span2 pageinfo-view">
			<a href="${pageContext.request.contextPath }/ajson.do">查看Json</a>
		</div>
		
		<div class="span5">
			<ul class="pager">
				<c:if test="${number<=1}">
					<li class="disabled"><a href="#">首页</a></li>
					<li class="disabled"><a href="#">上一页</a></li>
				</c:if>
				
				<c:if test="${number>1}">
					<li><a href="${pageContext.request.contextPath }/listAll/150/0/20.do" >首页</a></li>
					<li><a href="${pageContext.request.contextPath }/listAll/150/${number-2 }/20.do">上一页</a></li>
				</c:if>
				
				<c:if test="${number<totalPages}">
					<li><a href="${pageContext.request.contextPath }/listAll/150/${number }/20.do">下一页</a></li>
					<li><a href="${pageContext.request.contextPath }/listAll/150/${totalPages-1 }/20.do" >尾页</a></li>
				</c:if>
				
				<c:if test="${number>=totalPages}">
					<li class="disabled"><a href="#">下一页</a></li>
					<li class="disabled"><a href="#">尾页</a></li>
				</c:if>
			</ul>
		</div>
		
		<div class="span5" style="text-align: right;">
			<span class="label pageinfo-view">总共有${totalElements }条记录,当前是第<c:out value="${number }"></c:out>页,共<c:out value="${totalPages }"></c:out>页,每页显示${size }条</span>
		</div>
	</div>
</div>
<div class="container-fluid">
	<hr/>
	<footer>
	  <p align="center">&copy; maven-framework-project 2012</p>
	</footer>
</div>



</body>
</html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	height:28px;
	line-height: 28px;
}
.infomation{
	height: 12px;
	line-height: 12px;
	padding-top: 10px;
	padding-left: 20px;
}

.json-btn{
	background-color: #FFFFFF;
    border: 1px solid #DDDDDD;
    border-radius: 15px 15px 15px 15px;
    display: inline-block;
    padding: 5px 14px;
    line-height: 20px;
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
      	<p class="navbar-text pull-right">
		   		<shiro:authenticated>
		   			<shiro:principal/>
		   			拥有的角色[<shiro:hasRole name="Admin">管理员</shiro:hasRole>
		   			<shiro:hasRole name="User">普通用户</shiro:hasRole>]
		   			拥有的权限[<shiro:hasPermission name="user:edit">编辑</shiro:hasPermission>
		   			<shiro:hasPermission name="user:view">查看</shiro:hasPermission>]
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
				<shiro:hasPermission name="user:edit">
					<a href="${pageContext.request.contextPath }/modify/${contact.id }.do">修改</a>
					<a href="#" onclick="del('${contact.id }','${pageContext.request.contextPath }/del/${contact.id }.do')">删除</a>
				</shiro:hasPermission>
				<shiro:lacksPermission name="user:edit">
					<a>修改</a>
					<a>删除</a>
				</shiro:lacksPermission>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>
	
	
	
	<div class="row-fluid">
		
		<div class="span4 pageinfo-view">
			<a href="${pageContext.request.contextPath }/npage.do" class="json-btn">新增</a>
			<a href="${pageContext.request.contextPath }/ajson.do" class="json-btn">查看json</a>
			<a href="${pageContext.request.contextPath }/xml.do" class="json-btn">查看xml</a>
		</div>
		
		<div class="span4">
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
		
		<div class="span4" style="text-align: right;">
			<span class="label pageinfo-view">共${totalElements }条记录,<c:out value="${number }"></c:out>/<c:out value="${totalPages }"></c:out>,每页显示${size }条</span>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="modifyModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="modifyModalLabel">提示</h3>
  </div>
  <div class="modal-body">
    <p id="delcontent"></p>
  </div>
  <div class="modal-footer">
  	<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button>
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
  </div>
</div>

<footer>
	<div class="container-fluid">
		<hr/>
		<p align="center">&copy; maven-framework-project 2012</p>
	</div>
</footer>

<script type="text/javascript">
	function del(id,url){
		$('#delcontent').text('你确定要删除id为'+id+'的记录吗?');
		$('#modifyModal').modal('show');
		$('.modal-footer .btn-primary').off('click').on('click',function(){
			window.location.href=url;
		});
	}	
</script>

</body>
</html>
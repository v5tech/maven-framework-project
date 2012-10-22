<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring 3 MVC Series - Contact Manager</title>
    <style type="text/css">
    	span{
    		font-weight: bold;
    		font-family: sans-serif;
    		color: red;
    	}
    </style>
</head>
<body>
<h2>Contact Manager</h2>
<a href="${pageContext.request.contextPath }/npage.do">新增</a>
<a href="${pageContext.request.contextPath }/ajson.do">Json</a>
<hr/>
总共有${totalElements }条记录,当前是第<c:out value="${number }"></c:out>页,共<c:out value="${totalPages }"></c:out>,每页显示${size }条<br/>
<c:forEach var="contact" items="${alllist}">
	<span>Id</span>:<c:out value="${contact.id }"></c:out><br/>
	<span>FirstName</span>:<c:out value="${contact.firstname }"></c:out><br/>
	<span>LastName</span>:<c:out value="${contact.lastname }"></c:out><br/>
	<span>Email</span>:<c:out value="${contact.email }"></c:out><br/>
	<span>Telephone</span>:<c:out value="${contact.telephone }"></c:out><br/>
	<span>Age</span>:<c:out value="${contact.age }"></c:out><br/>
	<span>QQ</span>:<c:out value="${contact.qq }"></c:out>
	<a href="${pageContext.request.contextPath }/modify/${contact.id }.do">修改</a>
	<a href="${pageContext.request.contextPath }/del/${contact.id }.do">删除</a>
	<hr/>
</c:forEach>

<c:if test="${number<=1}">
	<a>首页</a>&nbsp;&nbsp;<a>上一页</a>&nbsp;&nbsp;
</c:if>

<c:if test="${number>1}">
	<a href="${pageContext.request.contextPath }/listAll/150/0/5.do">首页</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/listAll/150/${number-2 }/5.do">上一页</a>&nbsp;&nbsp;
</c:if>

<c:if test="${number<totalPages}">
	<a href="${pageContext.request.contextPath }/listAll/150/${number }/5.do">下一页</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/listAll/150/${totalPages-1 }/5.do">尾页</a>
</c:if>

<c:if test="${number>=totalPages}">
	<a>下一页</a>&nbsp;&nbsp;<a>尾页</a>
</c:if>
</body>
</html>
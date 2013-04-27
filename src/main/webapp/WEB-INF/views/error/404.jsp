<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>404 - 页面不存在</title>
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style>
</head>

<body>
	<center>
	  <h1>404公益页面</h1>
	  <iframe scrolling='no' frameborder='0' src='http://yibo.iyiyun.com/Home/js/yibo404' width='680' height='480' style="display:block;"></iframe>
	  <p><a href="<c:url value="/"/>">返回首页</a></p>
	</center>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>基于REST风格的请求</title>
    </head>
    <body>
        <h1><c:out value="${username}"/></h1>
        <hr/>
		<h1>This view page is from /hello/showUser/${username}/${pwd } !</h1>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Spring Security Access Denied</title>
    <style type="text/css">
	div.error {
	    width: 260px;
	    border: 2px solid red;
	    background-color: yellow;
	    text-align: center;
	}
    </style>
  </head>
  <body>
  	<div align="center">
    <h1>Spring Security Access Denied</h1>
    <div class="error">
             用户<sec:authentication property="name"/>,访问被拒绝<br>
      ${requestScope['SPRING_SECURITY_403_EXCEPTION'].message}
      <h1>访问被拒绝</h1>
    </div>
    </div>
  </body>
</html>

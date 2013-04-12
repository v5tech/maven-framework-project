<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Spring Security Login with Username and Password (Custom Page)</h3>
 
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td align="right">User:</td>
				<td><input type='text' name='j_username' value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}">
				</td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
				<td>
					<input name="submit" type="submit" value="submit" />
					<input name="reset" type="reset" value="reset"/>
				</td>
			</tr>
		</table>
 
	</form>
</body>
</html>
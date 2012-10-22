<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
<style>
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
</style>
</head>
<body>
<h2>Contact Manager</h2>
<form:form method="post" action="${pageContext.request.contextPath }/add.do" commandName="model">
 	<form:errors path="*" cssClass="errorblock" element="div" />
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
            <input type="submit" value="Add Contact"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>
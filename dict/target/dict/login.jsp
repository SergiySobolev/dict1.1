<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<title>Login</title>
</head>
<body>
	<html:form action="/login">
		<table border="0">
			<tbody>
				<tr>
                	<td colspan="2">
                    <bean:write name="LoginForm" property="error" filter="false"/>&nbsp;</td>                    
            	</tr>
				<tr>
					<td>Enter your name:</td>
					<td><html:text property="name" /></td>
				</tr>
				<tr>
					<td>Enter your email:</td>
					<td><html:text property="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td><html:submit value="Login" /></td>
				</tr>
			</tbody>
		</table>	
	</html:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
</head>
<body>
<h1>Login 登入</h1>
<form action="canLogin" method="post" id="loginForm">
	<table >
		<tr>
			<td>用户名：</td>
			<td><input id="loginname" name="loginname" type="text"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input id="password" name="password" type="password"></td>
		</tr>
	</table>
<input type="submit" >
</form>
<a href="<c:url value="/myWB/register" />">注册Register</a>
</body>
</html>
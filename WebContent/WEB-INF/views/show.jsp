<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY WEB</title>
</head>
<body>
<h1>员工列表</h1>
<ol type="1">
	<c:forEach items="${emp}" var="emp" >
	 	<li>姓名： ${emp.name} </li>
	</c:forEach>
</ol>


<a href="<c:url value="/login" />">Login</a> |
<a href="<c:url value="/register" />">注册Register</a> |
<a href="<c:url value="/showEmployees" />">查看员工</a>
</body>
</html>
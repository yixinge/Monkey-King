<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY WEB</title>
</head>
<style>
	span.error{
		color:red;
	}
	div.error{
		background-color: #ffcccc;
		border: 2px solid red;
	}
	label.error{
	color: red;
	}
	input.error{
	background-color: #ffcccc;
	}
</style>
<body>

<h1>欢迎注册</h1>
<h3>请输入相关信息</h3>
<%-- <sf:form method="POST" commandName="user">
	<sf:errors path="*" element="div" cssClass="error" />
	用户名：<sf:input path="username"/> <sf:errors path="username" cssClass="error"/><br/>
	<sf:label path="username" cssErrorClass="error">UserName</sf:label>:<sf:input path="username" cssErrorClass="error"/><br/>
	
	登入名：<sf:input path="loginname"/><br/>
	密码：<sf:password path="password" /><br/>
	<input type="submit" value="Register"/>
</sf:form> --%>

<form  method="post" enctype="multipart/form-data">
	用户名：<input type="text" name="username" /><br/>
	登入名：<input type="text" name="loginname" /><br/>
	密码：<input type="password" name="password" /><br/>
	头像：<input type="file" name="picture" accept="image/jpg,image/jpeg,image/png,image/gif" /><br/>
	<input type="submit" value="注册">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style type="text/css">
<!--
.errorMessage {
	color: red;
}
-->
</style>
</head>
<body>
	<s:form action="LoginAction">
		<s:textfield label="ID(アドレス)" name="id" />
		<s:password label="パスワード" name="password" maxlength="16"/>
		<s:submit value="確認" />
	</s:form>

</body>
</html>
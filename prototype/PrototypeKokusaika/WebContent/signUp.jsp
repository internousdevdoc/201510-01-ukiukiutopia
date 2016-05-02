<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success full Login</title>
</head>
<body>

	新規登録画面へ
	<br>
	<s:property value="#session.name_key" />
	
	<br>
	<INPUT type="button" value="戻る" onClick="history.back()">


</body>
</html>
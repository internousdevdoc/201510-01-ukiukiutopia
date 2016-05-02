<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<s:form action="LoginAction">
		<s:textfield label="ID" name="id" />
		<s:textfield label="パスワード" name="password" />
		<s:submit value="確認" />
	</s:form>
	
	<!-- <div class="social-wrap c">
<a href='TwitterLogin'><img src="./images/twitter-<fmt:message key="J" />.png"></a>
</div> -->

<a href='GoTwitterAction'><img src="./images/twitter-j.png"></a>
<a href='GoGoogleAction'><img src="./images/google-j.png"></a>
<a href='FacebookLogin'><img src="./images/facebook-j.png"></a>


</body>
</html>
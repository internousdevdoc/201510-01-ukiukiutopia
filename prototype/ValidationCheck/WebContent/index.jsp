<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
<html lang="ja">
<head>
<!--ロケールを入手-->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<!--<fmt:setLocale value="en" />-->

<!--propertyファイルの場所を定義。使いやすいようにlangという変数に格納-->
<fmt:setBundle basename="com.internousdev.property.Check" var="lang" />

<title><fmt:message key="questionnaire" bundle="${lang}" /></title>
</head>
<body>
	<div align="center">
	<s:form action="check">
		<fmt:message key="name" bundle="${lang}"/><s:textfield name="name" /><br>
		<fmt:message key="email" bundle="${lang}"/><s:textfield name="email" /><br>
		<fmt:message key="age" bundle="${lang}"/><s:textfield name="age" /><br>
		<s:submit value="OK" />
	</s:form>
	</div>
</body>
</html>
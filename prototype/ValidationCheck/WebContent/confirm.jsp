<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
<html lang="ja">
<head>
<!--ローカルを入手-->
<fmt:setLocale value="${pageContext.request.locale.language}" />

<!--propertyファイルの場所を定義。使いやすいようにlangという変数に格納-->
<fmt:setBundle basename="com.internousdev.property.Check" var="lang" />
<title><fmt:message key="confirm" bundle="${lang}"/></title>
</head>
<body>
	<s:fielderror />

	<fmt:message key="name" bundle="${lang}"/>:
	<s:property value="name" />
	<br /> <fmt:message key="email" bundle="${lang}"/>:
	<s:property value="email" />
	<br /> <fmt:message key="age" bundle="${lang}"/>:
	<s:property value="age" />

</body>
</html>
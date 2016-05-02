<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Login</title>
</head>
<body>
 ログインしました。<br>
<s:property value="#session.name_key"/>さん<br>

<s:form action="HistoryAction">
<s:submit value="購入履歴" />
</s:form>

<INPUT type="button" value="戻る" onClick="history.back()">
</body>
</html>
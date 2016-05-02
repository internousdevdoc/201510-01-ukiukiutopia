<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html">
<!--
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
  -->
<html>
<head>
 <link rel="stylesheet" href="css/main.css" type="text/css">
 <link rel="stylesheet" href="css/home.css" type="text/css">
 
  <title>うきうきUtopia HOME</title>
  
  </head>
  <header class="header">
   <div class="logo">
   <a href="" target="_self "><img src="image/ukiukiblack2.png" alt="うきうきUtopia"></a>
   </div>
   <link href="css/bootstrap.min.css" rel="stylesheet">
	<fmt:setLocale value="${pageContext.request.locale.language}" />
	<fmt:setBundle basename="com.internousdev.ukiukiutpia.properties.HomeAction" var="lang" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- CSSファイルを読み込ませて色や配置を指定する -->
	<!-- (CSSであることを示す)" --><!-- （読み込ませたいCSSファイルの指定） --><!-- MIMEタイプというWeb界の拡張子のようなもの　今回はCSSを指定している -->
	<link rel="stylesheet" href="css/main.css" type="text/css">
	<link rel="stylesheet" href="css/home.css" type="text/css">
	
	<!--タイトルを付けている　タブに表示され、検索エンジンで重要なキーワードと認識される+国際化-->  
	<title><fmt:message key="title" bundle="${lang}" /></title>
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="./footerFixed.js"></script>

</head>
<body>
<div class="row">
  <div class="link">
   <div class="col-md-4">
   <div class="createUser">
   <h3><fmt:message key="newSign" bundle="${lang}" /></h3>
 <a class="new" href="http://localhost:8080/Struts2/signUp.jsp"><fmt:message key="sign" bundle="${lang}" /></a>
 <p class="new-comment"><p class="new-comment"><h4><fmt:message key="free" bundle="${lang}" /><h4></p>
   </div>
  </div>

<div class="col-md-4">
 <div class="loginUser">
 <h3><fmt:message key="login" bundle="${lang}" /></h3>
<s:form action="home">
<input type=text name="userID" placeholder="<fmt:message key="id" bundle="${lang}" />">
    <input type=text name="userPassword" placeholder="<fmt:message key="pass" bundle="${lang}" />"><br>
    <input type="button" value="<fmt:message key="login" bundle="${lang}" />" onclick="http://localhost:8080/Struts2/mypage.jsp">
　<p  class="login-comment"><h4><fmt:message key="mouMember" bundle="${lang}" /></h4><br></p>
　</s:form>
</div>
</div>
 
 <div class="col-md-4">
 <div class="oauthUser">
 <h3><fmt:message key="snsAcount" bundle="${lang}" /></h3>
 <a href="TwitterLogin" target="_self "><img src="image/TwitterLogo.png" alt="twitterアカウントでログイン" class="tw"></a>
 <a href="FacebookLogin" target="_self "><img src="image/FB-f-Logo__blue_29.png" alt="facebookアカウントでログイン" class="fb"></a>
 <a href="GoGoogleAction" target="_self "><img src="image/google+.png" alt="Google+アカウントでログイン" class="gg"></a>
 <p  class="-comment"><h4><fmt:message key="aikon" bundle="${lang}" /></h4><br></p>
 </div>
 </div>
 
 <div class="clear">
 </div>
</div>

<div id="howto">
  <h3><fmt:message key="howTo" bundle="${lang}" /></h3>
  <h4><p><fmt:message key="howToUse" bundle="${lang}" /></p></h4>
</div>


<div id="access">
<h3><fmt:message key="jyusyo" bundle="${lang}" /></h3>
  <h4><p><fmt:message key="jyusyoS" bundle="${lang}" /><br></p></h4>
  <input type="button" value=" <fmt:message key="map" bundle="${lang}" />" onclick="">
</div>
 
	<footer class ="footer">

Copyright © <a href="index.html" target="_self ">うきうきUtopia</a> All Right Reserved.

</footer>
	

	
		
	



</body>

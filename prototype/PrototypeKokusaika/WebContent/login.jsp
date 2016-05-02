<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<fmt:setLocale value="${pageContext.request.locale.language}" />
	<fmt:setBundle basename="com.internousdev.struts2.properties.LoginAction" var="lang" />
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
	<!--ヘッダーにロゴを表示-->
	<header class = "header">
	<div class="logo">
	<a href="index.html" target="_self "><img src="image/ukiukiblack2.png" alt="うきうきUtopia"></a>
	</div>
	</header>


	
	<div>
  <!--同じページ内にリンクを作成-->
  <nav>
    <ul class="navi"> <!--ul=番号をつけないリスト　class=ラベリング-->
      <li><a href="#"><fmt:message key="home" bundle="${lang}" /></a></li> <!--a href=位置のid名を入力してリンクさせる-->
      <li><a href="#howto"><fmt:message key="howto" bundle="${lang}" /></a></li>
      <li><a href="#access"><fmt:message key="acsses" bundle="${lang}" /></a></li>
    </ul>
  </nav>
</div>

<!--新規登録画面、ログイン画面へのリンクを表示-->

<div>
  <table class="link">
    <tr>
  <td><a class="new" href="http://localhost:8080/Struts2/signUp.jsp"><input type = "submit"  value="<fmt:message key="sign" bundle="${lang}" />" /></a></td>
  <td><p class="new-comment"><fmt:message key="free" bundle="${lang}" /></p><td>
  <td></td>
	</tr>
 </table>
 <table class="jjj">
<s:form action="LoginAction">
<tr>
  <td><a class="login" href="http://localhost:8080/Struts2/mypage.jsp"><input type = "submit"   value="<fmt:message key="login" bundle="${lang}" />" />　</a></td>
　<td><p  class="login-comment"><fmt:message key="member" bundle="${lang}" /></p></td>
<s:textfield name="id" /><s:textfield name="password" />
　</s:form>
 </table>
 
 <table class="lll">
<!--SNSを利用したログインボタン-->
<tr>
<td>
 <a href="TwitterLogin" target="_self "><img src="image/TwitterLogo.png" alt="twitterアカウントでログイン" class="tw"></a>
 <a href="FacebookLogin" target="_self "><img src="image/FB-f-Logo__blue_29.png" alt="facebookアカウントでログイン" class="fb"></a>
 <a href="GoGoogleAction" target="_self "><img src="image/google+.png" alt="Google+アカウントでログイン" class="gg"></a>
</td>
</tr>
</table>
</div>
	

	
		
	



</body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="mypage.css" media="all">
    <link rel="stylesheet" type="text/css" href="chicket-syuryou.css" media="all">
</head>
<body>
  <header class="header">
     <a href="index.html" target="_self "><img class="logo" src="image/logo.png" alt="うきうきUtopia"></a>
    <div class="loginName">
    <p>会員名:<s:property value="#session.name_key"></s:property></p>
     <a href="" target="_self">[ログアウト]</a>
   </div>
    </header>
  <!--Bodyの位置をラベリング-->
<div class="container">
    <div class="form-chiket">チケット購入完了画面
    <p>購入完了しました。</p>
    <a href="mypage.html"><input type="submit" value="マイページに戻る"></a>
  </div>
<div>
  <footer class="footer">Copyright © <a href="index.html" target="_blank">うきうきUtopia　HOME</a> All Right Reserved.</footer>
</div>
</div>
</body>
</html>

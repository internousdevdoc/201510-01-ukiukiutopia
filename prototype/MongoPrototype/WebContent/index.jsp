<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM HomePage Builder 2001 V5.0.2 for Windows">
<TITLE></TITLE>
</HEAD>
<BODY>

<s:property value="#session.name_key"/>さん<br>

<table border="2">
<tr>
		<td>商品番号</td>
		<td>商品名</td>
		<td>数量</td>
</tr>
<s:iterator value="itemList1">

<tr>
        <td><s:property value="id" /></td>
        <td><s:property value="item" /></td>
        <td><s:property value="number" /></td>

</tr>
</s:iterator>
</table>


<s:form action ="MongoSelectAction">
	<INPUT type="submit" name="select" value="セレクト"></s:form>


	<s:form action ="MongoDeleteAction">
	<s:textfield label="商品番号" name="delid" />
	<INPUT type="submit" name="delete" value="デリート"></s:form>

<s:form action ="MongoInsertAction">
	<s:textfield label="商品番号" name="insertid" />
	<s:textfield label="アイテム名" name="insertitem" />
	<s:textfield label="数量" name="insertnumber" /><!-- 変更 -->
	<INPUT type="submit" value="インサート">
	</s:form>

	<!--<s:form action ="MongoInsertAction">
	<s:textfield label="アイテム名" name="item" />
	<s:textfield label="数量" name="inumber" />
	<INPUT type="submit" name="insert" value="インサート"></s:form>-->

<s:form action ="MongoUpdateAction">
	<s:textfield label="商品番号" name="updateid" />
	<s:textfield label="数量" name="updatenumber" />
	<INPUT type="submit" name="update" value="アップデート"></s:form>


</BODY>
</HTML>

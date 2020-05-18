<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="utf-8"%>
     <%@ page import="javax.servlet.http.HttpServlet" %>
      <%@ page import="javax.servlet.http.HttpServletRequest" %>
      <%@ page import="java.util.HashMap" %>
       <%@ page import="java.util.ArrayList" %>
        <%@ page import="java.util.List" %>
        <%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>

#para1
{
	text-align:center;
	color:white;
}
#tableMain
{
	align:center;
}
#submitButton
{

}

</style>

<%  

	String id = (String)request.getAttribute("id");
	String inPrice = (String)request.getAttribute("inPrice");
	String salePrice = (String)request.getAttribute("salePrice");
	String mark = (String)request.getAttribute("mark");

%>
<title>更新商品信息</title>
</head>
<script type="text/javascript">
function initFunc(){
	document.getElementById('inPrice').value='<%=inPrice%>';
	document.getElementById('salePrice').value='<%=salePrice%>';
	document.getElementById('mark').value='<%=mark%>';
}
function doSubmit(id){
	document.UpdateSubmit.id.value = id;
	document.UpdateSubmit.inPrice.value = document.getElementById('inPrice').value;
	document.UpdateSubmit.salePrice.value = document.getElementById('salePrice').value;
	document.UpdateSubmit.mark.value = document.getElementById('mark').value;
	document.getElementById('UpdateSubmit').submit();
}



</script>
<body onload="initFunc()" style="background: url(images/back1.jpg)" >
<h1 id ="para1" >更新商品信息  </h1>
<center>
<table  id="tableMain" border="2px" cellspacing="0" width="500px" >
<tr>
	<td colspan = "3" >二维码码号</td>
	<td >进价</td>
	<td >售价</td>
	<td >备注</td>
</tr>
<tr>
	<td colspan = "3" id = "idinput"><%=id%></td>
	<td ><input id= "inPrice" type="text" ></td>
	<td><input id= "salePrice" type="text" ></td>
	<td><input id= "mark" type="text" ></td>
</tr>
</table>
<br><br>
	<input id ="submitButton" type ="button"
		 value = " 确 认 更 新 " style= "height:80px;width:120px " 
		 		onclick="doSubmit('<%= id%>')">
	<input id ="back" type ="button"
		 value = " 返  回 " style= "height:80px;width:120px " 
		 		onclick="javascript:history.go(-1)" >
</center>
<form  name= "UpdateSubmit" id="UpdateSubmit" class="form-signin" 
	role="form" method="post" action="UpdateSubmitServlet">
	<input type="hidden" name="id"  value="">
	<input type="hidden" name="inPrice"  value="">
	<input type="hidden" name="salePrice"  value="">
	<input type="hidden" name="mark"  value="">
</form>
</body>
</html>
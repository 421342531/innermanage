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
<title> 删除商品信息</title>
<script type="text/javascript">
function doSubmit(){
	
	document.getElementById('DeleteSubmit').id.value ='<%=id%>';
	document.getElementById('DeleteSubmit').inPrice.value ='<%=inPrice%>';
	document.getElementById('DeleteSubmit').salePrice.value ='<%=salePrice%>';
	document.getElementById('DeleteSubmit').mark.value ='<%=mark%>';
	document.getElementById('DeleteSubmit').submit();
	
	
}

</script>
</head>
<body style="background: url(images/back1.jpg)">
<h1 id ="para1" >删除商品信息  </h1>
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
	<td ><%=inPrice%></td>
	<td><%=salePrice%></td>
	<td><%=mark%></td>
</tr>
</table>
<br><br>
	<input id ="submitButton" type ="button" 
	value = "确认删除" style= "height:80px;width:120px " onclick="doSubmit()">
	<input id ="back" type ="button"
		 value = " 返  回 " style= "height:80px;width:120px " 
		 		onclick="javascript:history.go(-1)" >
</center>

<form name= "DeleteSubmit" id="DeleteSubmit" class="form-signin" 
	role="form" method="post" action="DeleteSubmitServlet">
	<input type="hidden" name="id"  value="">
	<input type="hidden" name="inPrice"  value="">
	<input type="hidden" name="salePrice"  value="">
	<input type="hidden" name="mark"  value="">
</form>
</body>
</html>
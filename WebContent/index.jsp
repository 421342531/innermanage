<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %> 

    <%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String alertPassword = "false";
	 alertPassword =  (String)request.getAttribute("passwordAlert");//true:��Ҫ��ʾ�������
	if(alertPassword==null){
		alertPassword = "false";
	}
	 System.out.println("alertPassword="+alertPassword);
%>

<style>

#para1
{
	text-align:center;
}
#para2
{
	text-align:center;
}
#para3
{
	text-align:center;
}
#para4
{
	text-align:center;
}


</style>
<script type="text/javascript">
function init(){
	if('<%=alertPassword%>'=="true"){
		alert("����������������룡");
	}
	
}

function doSubmit(){
	//alert("����������ǣ�"+document.getElementById('password').value);
	if(document.getElementById('password').value==""){
		alert("�������½���룡");
		return;
	}
	document.submitForm.submit();
}

</script>
<title>��Ʒ�ڲ�����ϵͳ</title>
</head>
<body onload = init(); style="background: url(images/back1.jpg)">

<center>
<br><br><br><br><br>
<h1 id ="para1" >�������½���� </h1>
<form  name="submitForm" class="form-signin" role="form" method="post" action="LoginServlet">
<h2 id ="para3">�� �� :  </a><input type="password" 
	style="height:30px;width:100px;" name = "password" id = "password" /></br></br>
	<input type="button" value="��  �� " style="height:60px;width:100px;" onclick="doSubmit()" />

</center>
</form>
</body>
</html>
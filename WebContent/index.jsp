<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %> 

    <%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
<%
	String alertPassword = "false";
	 alertPassword =  (String)request.getAttribute("passwordAlert");//true:需要提示密码错误
	if(alertPassword==null){
		alertPassword = "false";
	}
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
#bodyid
{
	background: url("images/back1.jpg") no-repeat;
}
#button
{
	width:280px;
	border:none;
	color:#FFFFFF!important;
	background-color:#FF9000;
	height:30px;
	margin-top:10px;
	border-radius:28px;
	outline:0;
	fontsizze:20px;

}
#password
{
	border:1px solid #ddd;
	display:inline-block;
	width:243px;
	border-radius:4px;
	position:relative;
	padding-left:10px;
	background-color:#FFFFFF;
	overflow:hidden;



}


</style>
<script type="text/javascript">
function init(){
	if('<%=alertPassword%>'=="true"){
		alert("密码错误，请重新输入！");
	}
	
}

function doSubmit(){
	//alert("输入的密码是："+document.getElementById('password').value);
	if(document.getElementById('password').value==""){
		alert("请输入登陆密码！");
		return;
	}
	document.submitForm.submit();
}
function datetime() {
	 	var now = new Date();
	 	document.getElementById("time").value = now.getFullYear() + "-"
	 	+ (now.getMonth() + 1) + "-" + now.getDate();
	 	document.getElementById("time").value += " " + now.getHours() + ":"
	 	+ now.getMinutes() + ":" + now.getSeconds();
		 }
	 window.setInterval("datetime()", 1000);

</script>
<title>商品内部管理系统</title>
</head>
<body id ="bodyid" onload = init(); >
<div>
	<div style="width:30%; position:absolute; right:250px; top:0px;" >
		<span> 当前时间:</span>
			<input id="time" style="text-align: center;" />
	</div>
	<div style="width:30%; position:absolute; right:0px; top:0px; 
					text-decoration: underline;" onclick="doSubmit()" >
		账户中心
	</div>
</div>
<center>

<br><br><br><br><br>
<h1 id ="para1" >请输入登陆密码 </h1>
<form  name="submitForm" class="form-signin" role="form" method="post" action="LoginServlet"/>


<h2 id ="para3">密 码 :  </a>
 <input type="password" placeholder="请输入密码"
	style="height:30px;width:100px;" name = "password" id = "password" /></br></br>
	<input id="button" type="button" value="提  交 " plcaeholder="密码" style="height:60px;width:100px;" onclick="doSubmit()" />

</center>

<div id="main" style="width: 600px;height:400px;display:none;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
       // var myChart = echarts.init(dom, 'dark');
         var   myChart = echarts.init(document.getElementById('main'));
 
        myChart.setOption({
            series : [
                {
                    name: '访问来源',
                    type: 'pie',    // 设置图表类型为饼图
                    radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                    roseType: 'angle',
                    data:[          // 数据数组，name 为数据项名称，value 为数据项值
                        {value:235, name:'视频广告'},
                        {value:274, name:'联盟广告'},
                        {value:310, name:'邮件营销'},
                        {value:335, name:'直接访问'},
                        {value:400, name:'搜索引擎'}
                    ]
                }
            ]
        })
    </script>
</body>
</html>
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
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
<%
	
    int arrayinprice[] = (int[])request.getAttribute("inPriceTongji");//进价集合
    int arraysaleprice[] =arrayinprice; //售价集合  
%>
<title>欢迎来到商品管理页面!</title>
<style>
hr {color:sienna;}
p {margin-left:20px;}
body {background-image:url("images/back40.gif");}
#para1
{
	text-align:center;
}
#tableMain
{
	align:center;
	valign：center;
	border:none;
	margin-bottom:10px;
	border-collapse:collapse;
	width:800px;
	text-align:center;
	margin:0 auto;
}
#tableThread
{

	align:center;
	valign：center;
	border:none;
	margin-bottom:10px;
	border-collapse:collapse;
	width:800px;
	text-align:center;
	margin:0 auto;
	background-color:#FFF8EE;


}
#blueButton
{

text-decoration:underline;
}
#redButton
{

text-decoration:underline;
}
#button
{
	width:280px;
	border:none;
	color:#FFFFFF!important;
	background-color:#FF9000;
	height:20px;
	margin-top:10px;
	border-radius:28px;
	outline:0;
	fontsizze:20px;

}


</style>
<script type="text/javascript">


function doRefresh(){
	document.refreshForm.submit();
}
function doExit(){
	document.exitForm.submit();
}
function doTongji(){
	document.TongjiForm.submit();
}
function dobackForm(){
	document.backForm.submit();
}


</script>
</head>
<body style="background: url(images/back1.jpg)">
<h1 id="para1">欢迎来到商品管理页面！</h1> 
<div>
	<div id="main" style="width: 600px;height:400px;" >echarts.js</div>
</div>
<script type="text/javascript">
  // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
 
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '进价价格区间图'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ["0～10元","10～20元","20～50","50～100","100以上"]
            },
            yAxis: {},
            series: [{
            	barWidth :30,
                name: '数量',
                type: 'bar',
                data: ['<%=arrayinprice[0]%>',
                		'<%=arrayinprice[1]%>', 
                			'<%=arrayinprice[2]%>', 
                				'<%=arrayinprice[3]%>', 
                					'<%=arrayinprice[4]%>']
            }]
        };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
</script>
<script type="text/javascript">
  // 基于准备好的dom，初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('main1'));
 
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '售价价格区间图'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ["0～10元","10～20元","20～50","50～100","100以上"]
            },
            yAxis: {},
            series: [{
            	barWidth :30,
                name: '数量',
                type: 'bar',
                data: ['<%=arraysaleprice[0]%>',
                		'<%=arraysaleprice[1]%>', 
                			'<%=arraysaleprice[2]%>', 
                				'<%=arraysaleprice[3]%>', 
                					'<%=arraysaleprice[4]%>']
            }]
        };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart1.setOption(option);
    </script>
<center>
	<div id="main1" style="width: 600px;height:400px;display:none;">请刷新！</div>
</center>
<center>

	<input id ="button" type="button" value="刷 新" style="height:80px;width:120px " onclick="doRefresh()" />
	<input id ="button" type="button" value="返 回" style="height:80px;width:120px " onclick="dobackForm()" />
	
	<input id ="button" type ="button"
		 value = "退  出 " style= "height:80px;width:120px " 
		 		 onclick="doExit()" >
</center>
<form id="toUpdatePage" class="form-signin" role="form" method="post" action="ToUpdateServlet">
<input type="hidden" name="id"  value="">
<input type="hidden" name="inPrice"  value="">
<input type="hidden" name="salePrice"  value="">
<input type="hidden" name="mark"  value="">
</form>

<form id="ToDeletePage" class="form-signin" role="form" method="post" action="ToDeletePage">
<input type="hidden" name="id"  value="">
<input type="hidden" name="inPrice"  value="">
<input type="hidden" name="salePrice"  value="">
<input type="hidden" name="mark"  value="">
</form>

<form name = "refreshForm" class="form-signin" role="form" method="post" action="TongjiServlet">
<input type="hidden" name="id"  value="">
<input type="hidden" name="inPrice"  value="">
<input type="hidden" name="salePrice"  value="">
<input type="hidden" name="mark"  value="">
</form>

<form name = "exitForm" class="form-signin" role="form" method="post" action="ExitServlet">
<input type="hidden" name="id"  value="">
<input type="hidden" name="inPrice"  value="">
<input type="hidden" name="salePrice"  value="">
<input type="hidden" name="mark"  value="">
</form>

<form name = "downloadForm" class="form-signin" role="form" method="post" action="DownloadServlet">
<input type="hidden" name="id"  value="">
<input type="hidden" name="inPrice"  value="">
<input type="hidden" name="salePrice"  value="">
<input type="hidden" name="mark"  value="">
</form>

<form name = "TongjiForm" class="form-signin" role="form" method="post" action="TongjiServlet">
<input type="hidden" name="id"  value="">
<input type="hidden" name="inPrice"  value="">
<input type="hidden" name="salePrice"  value="">
<input type="hidden" name="mark"  value="">
</form>

<form  name="backForm" class="form-signin" role="form" method="post" action="refreshServlet">
</form>



</body>
</html>
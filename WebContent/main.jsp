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
	String preAction = (String)request.getAttribute("preAction");
    List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("list");
    
    
    int arrayinprice[] = (int[])request.getAttribute("inPriceTongji");//进价集合
    int arraysaleprice[] = (int[])request.getAttribute("outPriceTongji");//进价集合  
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
}
#blueButton
{

text-decoration:underline;
}
#redButton
{

text-decoration:underline;
}



</style>
<script type="text/javascript">
function init(){
	//0:update 1:delete 2:refersh
	if('<%=preAction%>'=="0"){
		alert("更新成功！");
		return ;
	}
	//0:update 1:delete 2:refersh
	if('<%=preAction%>'=="1"){
		alert("删除成功！");
		return ;
	}
	//0:update 1:delete 2:refersh
	if('<%=preAction%>'=="2"){
		alert("刷新成功！");
		return ;
	}else{
		return ;
	}
	
	
}
function update(index,id,inPrice,salePrice,mark){
	
	document.getElementById('toUpdatePage').id.value =id;
	document.getElementById('toUpdatePage').inPrice.value =inPrice;
	document.getElementById('toUpdatePage').salePrice.value =salePrice;
	document.getElementById('toUpdatePage').mark.value =mark;
	document.getElementById('toUpdatePage').submit();
}

function deleteInfo(index,id,inPrice,salePrice,mark){
	document.getElementById('ToDeletePage').id.value =id;
	document.getElementById('ToDeletePage').inPrice.value =inPrice;
	document.getElementById('ToDeletePage').salePrice.value =salePrice;
	document.getElementById('ToDeletePage').mark.value =mark;
	document.getElementById('ToDeletePage').submit();
}

function doRefresh(){

	//alert("refresh");
	document.refreshForm.submit();
}
function doExit(){
	document.exitForm.submit();
}
function doDownload(){
	document.downloadForm.submit();
}

</script>
</head>
<body onload="init()" style="background: url(images/back1.jpg)">
<h1 id="para1">欢迎来到商品管理页面！</h1> 
<center>
<table id="tableMain" border="1px" cellspacing="0" width="500px"  >
<tr>
	<td >序号</td>
	<td  colspan = "4">二维码码号</td>
	<td >进价</td>
	<td >售价</td>
	<td >备注</td>
	<td >更新信息</td>
	<td >删除商品</td>
</tr>
<% 
int index =0;
for(Map map:list){ index++;%>
<tr>
    <td id ='<%=index%>'  ><%=index%> </td>
	<td colspan = "4"  ><%= map.get("id")%> </td>
	<td  ><%= map.get("inPrice")%> 元</td>
	<td  ><%= map.get("salePrice")%> 元</td>
	<td  ><%= map.get("mark")%></td>
	<td  id ="blueButton"  onclick="update('<%=index %>',
											'<%=map.get("id")%>',
											'<%=map.get("inPrice")%>',
											'<%=map.get("salePrice")%>',
											'<%=map.get("mark")%>')
											">点击更新</td>
	<td  id ="redButton"  onclick="deleteInfo('<%=index %>',
											'<%=map.get("id")%>',
											'<%=map.get("inPrice")%>',
											'<%=map.get("salePrice")%>',
											'<%=map.get("mark")%>')
											">点击删除</td>
</tr>
<%} %>
</table>
	<br><br>
	<input id ="freshButton" type="button" value="刷 新" style="height:80px;width:120px " onclick="doRefresh()" />
	<input id ="freshButton" type="button" value="导出到excel" style="height:80px;width:120px " onclick="doDownload()" />
		<input id ="back" type ="button"
		 value = "退  出 " style= "height:80px;width:120px " 
		 		 onclick="doExit()" >
</center>
<div id="main" style="width: 600px;height:400px;">echarts.js</div>
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
<div id="main1" style="width: 600px;height:400px;">echarts.js</div>
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

<form name = "refreshForm" class="form-signin" role="form" method="post" action="refreshServlet">
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



</body>
</html>
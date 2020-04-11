<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改车次信息</title>
<link rel="stylesheet" rev="stylesheet" href="/graduate/css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
	
	function $(id){
		return document.getElementById(id); 
	}
	
 	function checkTrainNum(){ 
		var train_num = $("train_num").value;
		var reg = /^[G|T|K|D|L]{0,1}[0-9]{1,5}$/;
		if(train_num==""){
			$("trainNumSpan").innerHTML="车次不能为空！ ";
			return false;
		}else if(reg.test(train_num)==false){
			$("trainNumSpan").innerHTML="车次格式不正确！ ";
			return false;	
		}else{
			$("trainNumSpan").innerHTML="";
			return true;
		}
	}
	function checkStation(){
		var station = $("train_num").value;
		if(station==""){
			$("stationSpan").innerHTML="经过车站不能为空！ ";
			return false;
		}else{
			$("stationSpan").innerHTML="";
			return true;
		}
	}
	function checkAtime(){
		var a_time = $("a_time").value;
		if(a_time==""){
			$("aTimeSpan").innerHTML="到站时间不能为空！ ";
			return false;
		}else{
			$("aTimeSpan").innerHTML="";
			return true;
		}
	}
	function checkGtime(){
		var g_time = $("g_time").value;
		if(g_time==""){
			$("gTimeSpan").innerHTML="发车时间不能为空！ ";
			return false;
		}else{
			$("gTimeSpan").innerHTML="";
			return true;
		}
	}
	function checkPrice(){
		var price = $("price").value;
		if(price==""){
			$("priceSpan").innerHTML="票价不能为空！ ";
			return false;
		}else{
			$("priceSpan").innerHTML="";
			return true;
		}
	}
	function checkAmount(){
		var amount = $("amount").value;
		var reg = /^[1-9]\d{2,4}$/;
		if(amount==""){
			$("amountSpan").innerHTML="额定票数不能为空！ ";
			return false;
		}else if(reg.test(amount)==false){
			$("amountSpan").innerHTML="额定票数不正确！ ";
			return false;
		}else{
			$("amountSpan").innerHTML="";
			return true;
		}
	}
	function checkRemainder(){
		var remainder = $("remainder").value;
		var amount = $("amount").value;
		if(remainder==""){
			$("remainderSpan").innerHTML="剩余票数不能为空！ ";
			return false;
		}else if(amount!=remainder){
			$("remainderSpan").innerHTML="剩余票数需等于额定票数！ ";
			return false;
		}else{
			$("remainderSpan").innerHTML="";
			return true;
		}
	}
	
	function checkit()
	{
		if(checkTrainNum() && checkStation() && checkAtime() && checkGtime() && checkPrice() && checkAmount() && checkRemainder() ){
			return true;
		}else{
			return false;
		}
	}
</script>

</head>

<body class="ContentBody">
  <form action="/graduate/AddTrainServlet" method="post"  name="form1"  onsubmit="return checkit();">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >车次信息修改</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					
					  <tr>
					    <td nowrap="nowrap" align="right" >车次:</td>
					    <td><input name='train_num' id='train_num' type="text" class="text" style="width:154px" onblur="checkTrainNum();" />
				         	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，格式如：T242,G242,D242,T21,8567</span>
				        	<span style="color:red;font-size:15px;" id="trainNumSpan"></span>
				        </td>
					  </tr>
					  
					  <tr >
					    <td nowrap="nowrap" align="right" >经过车站:</td>
					    <td>
					    	<textarea name="station" id="station" class="text" cols="45" rows="3" onblur="checkStation();" ></textarea>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，格式如：蚌埠/淮南/水家湖/合肥</span>
			        		<span style="color:red;font-size:15px;" id="stationSpan"></span>
				        </td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right" >到站时间:</td>
					    <td>
				        	<textarea name="a_time" id="a_time" class="text" cols="45" rows="3" onblur="checkAtime();" ></textarea>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，格式如：---/07:49/08:00/08:25</span>
			        		<span style="color:red;font-size:15px;" id="aTimeSpan"></span>
				        </td>
					  </tr>
					  
					  <tr>
					    <td nowrap="nowrap" align="right" >发车时间:</td>
					    <td>
				        	<textarea name="g_time" id="g_time" class="text" cols="45" rows="3" onblur="checkGtime();" ></textarea>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，格式如：07:33/07:51/08:02/---</span>
			        		<span style="color:red;font-size:15px;" id="gTimeSpan"></span>
				        </td>
					  </tr>
					  
					  <tr>
					    <td nowrap="nowrap" align="right" >票价:</td>
					    <td>
				        	<textarea name="price" id="price" class="text" cols="45" rows="3" onblur="checkPrice();" ></textarea>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，格式如：0.0/19.5/28.5/60.5</span>
			        		<span style="color:red;font-size:15px;" id="priceSpan"></span>
				        </td>
					  </tr>
					  
					   <tr>
					    <td nowrap="nowrap" align="right" >额定票数:</td>
					    <td><input name='amount' id='amount' type="text" class="text" style="width:154px" onblur="checkAmount();" />
				         	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，为正整数</span>
				        	<span style="color:red;font-size:15px;" id="amountSpan"></span>
				        </td>
					  </tr>
					  
					 <tr>
					    <td nowrap="nowrap" align="right" >剩余票数:</td>
					    <td><input name='remainder' id='remainder' type="text" class="text" style="width:154px" onblur="checkRemainder();" />
				         	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，为正整数,且不大于额定票数</span>
				        	<span style="color:red;font-size:15px;" id="remainderSpan"></span>
				        </td>
					  </tr>
					  
					  </table>
			  <br />
				</fieldset></TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="save" value="保存" class="button"/>　
			
			<input type="button" name="return" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>

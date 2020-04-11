<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style1.css" />

<script type="text/javascript">

	function getTime(){
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth()+1;
		var day = today.getDate();
		var hour = today.getHours();
		var minute = today.getMinutes();
		var second = today.getSeconds();
		var weeks = today.getDay();
		var week ;
		if(weeks == 0){
			week = "天";
		}else if(weeks ==1){
			week = "一";
		}else if(weeks ==2){
			week = "二";
		}else if(weeks ==3){
			week = "三";
		}else if(weeks ==4){
			week = "四";
		}else if(weeks ==5){
			week = "五";
		}else if(weeks ==6){
			week = "六";
		}
		document.getElementById("time").innerHTML = year + "年"+month+"月"+day+"日" + "   星期"+ week + "   " +hour +":"+minute+":"+second;
	}
	
	function interval(){
		//setInterval("getTime()",1000);	
	}
</script>
</head>
<body onload="interval()">
<div id="header">
	<img src="../picture/top_login.jpg" width="100%" height="160px"/>
	<div id="blue">
		<div id="time">欢迎!</div>
    </div>
</div>
</body>
</html>

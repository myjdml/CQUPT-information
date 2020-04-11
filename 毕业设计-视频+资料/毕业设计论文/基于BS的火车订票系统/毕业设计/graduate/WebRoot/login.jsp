<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>铁路票务管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<script type="text/javascript">
	function checkLogin(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var checked = document.getElementById("checked");

	if(username=="" || password==""){
		checked.innerHTML = "用户名或密码不能为空！";
		return false;
	}

	return true;
	}
	
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
		document.getElementById("timeLogo").innerHTML = year + "年"+month+"月"+day+"日" + "   星期"+ week + "   " +hour +":"+minute+":"+second;
	}
	
	function interval(){
		//setInterval("getTime()",1000);	
	}
</script>

<style type="text/css">
#login .msg_check{ color:#F00; float:right; margin-top:4px; margin-right:110px;}
</style>

</head>

<body style="background-color:#e5e5e5" onload="interval()">
<div id="case">
<div id="topLogo"><img src="picture/top_login.jpg" height="148px"/> </div>
<div id="blue">
	<div id="timeLogo"></div>
</div>
<div id="navLogin">
<table>
    <tr>
        <td>
            <div id="login">
            	<img src="picture/enter_font1.jpg"/>
                <form method="post" action="/graduate/LoginServlet" onsubmit='return checkLogin();'>
					<dl>
						<dt>用户名：</dt>
						<dd><input type="text" name="username" id="username" class="input-text" /></dd>
						<dt>密　码：</dt>
						<dd><input type="password" name="password" id="password" class="input-text" /></dd>
					</dl>
                    <div class="msg_check" id="checked">${alert}</div>
					<div class="buttons">
						<input type="submit" name="button" value="登录系统"  class="input-button" />
						<input type="reset" name="reset" value="重　　填" class="input-button" />
					</div>
  				</form>
      	   </div>
        </td>
        <td>
        	<div id="register">
            	<img src="picture/register.jpg" />
                <a href="#">
                	<div class="buttons">
                	<form method="post" action="/graduate/files/register.jsp">
                	  <input type="submit" name="reset2" value="注  册" class="input-button" />
                	</form>
                	</div>
                </a>
            </div>
        </td>
    </tr>
</table>
</div>
<div id="waterline"></div>
<div id="declared">&copy;</div>
</div>
</body>
</html>

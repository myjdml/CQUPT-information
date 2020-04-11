<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>密码修改</title>
<link rel="stylesheet" rev="stylesheet" href="/graduate/css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
	
	function $(id){
		return document.getElementById(id); 
	}
	function checkOldPassword(){
		var oldPassword = $("oldPassword").value;
		var reg = /^\S{6,30}$/;
		if(oldPassword == ""){
			$("oldPasswordSpan").innerHTML="原始密码不能为空！ ";
			return false;
		}else if(reg.test(oldPassword)==false){
			$("oldPasswordSpan").innerHTML="原始密码格式不正确！ ";
			return false;
		}else{
			$("oldPasswordSpan").innerHTML="";
			return true;
		}
	}
	function checkNewPassword(){
		var newPassword = $("newPassword").value;
		var reg = /^\S{6,30}$/;
		if(newPassword==""){
			$("newPasswordSpan").innerHTML="新密码不能为空！";
			return false;
		}else if(reg.test(newPassword)==false){
			$("newPasswordSpan").innerHTML="新密码格式不正确！ ";
			return false;
		}else{
			$("newPasswordSpan").innerHTML="";
			return true;
		}
	}
	function checkNewPasswordAgain(){
		var newPasswordAgain = $("newPasswordAgain").value;
		var newPassword = $("newPassword").value;
		if(newPasswordAgain==""){
			$("newPasswordAgainSpan").innerHTML="确认密码不能为空！";
			return false;
		}else if(newPassword!=newPasswordAgain){
			$("newPasswordAgainSpan").innerHTML="新密码与确认密码不一致！ ";
			return false;
		}else{
			$("newPasswordAgainSpan").innerHTML="";
			return true;
		}
	}
	function checkit()
	{
		return true;
	}
</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="/graduate/UpdatePasswordServlet" method="post"  name="form1"  onsubmit="return checkit();">
	<input type="hidden" name="userId" value="${commonUsers.id}">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >个人密码修改</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  
					  <tr >
					    <td nowrap="nowrap" align="right" >原始密码:</td>
					    <td><input name='oldPassword' id='oldPassword' type="password" class="text" style="width:154px" onblur="checkOldPassword();"/>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，请输入原密码</span>
			        		<span style="color:red;font-size:15px;" id="oldPasswordSpan"></span>
				        </td>
					  </tr>
					  <tr >
					    <td nowrap="nowrap" align="right" >新密码:</td>
					    <td><input name='newPassword' id='newPassword' type="password" class="text" style="width:154px" value="${user.password}" onblur="checkNewPassword();"/>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，不少于6位字符，不大于30位，不能包含空格</span>
			        		<span style="color:red;font-size:15px;" id="newPasswordSpan"></span>
				        </td>
					  </tr>
					  <tr >
					    <td nowrap="nowrap" align="right" >密码确认:</td>
					    <td><input name='newPasswordAgain' id='newPasswordAgain' type="password" class="text" style="width:154px" value="${user.password}" onblur="checkNewPasswordAgain();"/>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，请再次输入密码</span>
			        		<span style="color:red;font-size:15px;" id="newPasswordAgainSpan"></span>
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
			<TD colspan="2" style="padding-left:350px;" height="50px">
			<input type="submit" name="save" value="确定" class="button" />　
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>

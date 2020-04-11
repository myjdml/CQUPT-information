<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>普通用户注册</title>
<link rel="stylesheet" rev="stylesheet" href="/graduate/css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
	
	function $(id){
		return document.getElementById(id); 
	}
	
	function checkUsername(){
		var username = $("username").value;
		var reg = /^\w{6,30}$/;
		if(username==""){
			$("usernameSpan").innerHTML="用户名不能为空！ ";
			return false;
		}else if(reg.test(username)==false){
			$("usernameSpan").innerHTML="用户名格式不正确！ ";
			return false;	
		}else{
			$("usernameSpan").innerHTML="";
			return true;
		}
	}
	function checkPassword(){
		var password = $("password").value;
		var reg = /^\S{6,30}$/;
		if(password == ""){
			$("passwordSpan").innerHTML="密码不能为空！ ";
			return false;
		}else if(reg.test(password)==false){
			$("passwordSpan").innerHTML="密码格式不正确！ ";
			return false;
		}else{
			$("passwordSpan").innerHTML="";
			return true;
		}
	}
	function checkConfirmPassword(){
		var confirmPassword = $("confirmPassword").value;
		var password = $("password").value;
		if(confirmPassword==""){
			$("confirmPasswordSpan").innerHTML="确认密码不能为空！";
			return false;
		}else if(password!=confirmPassword){
			$("confirmPasswordSpan").innerHTML="密码与确认密码不一致！ ";
			return false;
		}else{
			$("confirmPasswordSpan").innerHTML="";
			return true;
		}
	}
	function checkpapersNum(){
		var papers_num = $("papers_num").value;
		if(papers_num==""){
			$("paperNumSpan").innerHTML="证件号码不能为空！";
			return false;
		}else{
			$("papers_num").innerHTML="";
			return true;
		}
	}
	function checkName(){
		var name = $("name").value;
		if(name==""){
			$("nameSpan").innerHTML="姓名不能为空！";
			return false;
		}else{
			$("nameSpan").innerHTML="";
			return true;
		}
	}
	function checkPhone(){
		var phone = $("phone").value;
		var reg = /^1[3-9]\d{9}$/;
		if(phone==""){
			$("phoneSpan").innerHTML="手机号码不能为空！";
			return false;
		}else if(reg.test(phone)==false){
			$("phoneSpan").innerHTML="手机格式不正确！";
			return false;
		}else{
			$("phoneSpan").innerHTML="";
			return true;
		}
	}
	function checkEmail(){
		var email = $("email").value;
		var reg = /^\w+@\w+\.[a-zA-Z]{2,3}(\.[a-zA-Z]{2,3})?$/;
		if(email==""){
			$("emailSpan").innerHTML="电子邮箱不能为空！";
			return false;
		}else if(reg.test(email)==false){
			$("emailSpan").innerHTML="邮箱格式不正确！";
			return false;
		}else{
			$("emailSpan").innerHTML="";
			return true;
		}
	}
	
	
	function checkLogin(){
		if(checkUsername()&&checkPassword&&checkConfirmPassword()&&checkpapersNum&&checkName()&&checkPhone()
			&&checkEmail()){
			return true;
		}else{
			return false;
		}
	}

</script>

</head>

<body class="ContentBody">
  <form action="/graduate/RegisterServlet" method="post"  name="form"  onsubmit='return checkLogin();'>
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >用户注册</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  
					  <tr>
					  	<td class="information-sort">基本信息<span class="red" style="font-size:12px;">(*为必填项)</span></td>
					  </tr>
					  <tr>
					  	<td colspan="4" ><hr/></td>
					  </tr>
					
					  <tr>
					    <td nowrap="nowrap" align="right" >用户名:</td>
					    <td>
						    <input name='username' id='username' type="text" class="text" style="width:154px" onblur="checkUsername()" />
					        <span class="red">* </span>
					        <span style="color:#2e3192;">必填，由字母、数字或“_”组成，长度不少于6位，不多于30位</span>
					        <span style="color:red;font-size:15px;" id="usernameSpan"></span>
				        </td>
					  </tr>
					  <tr >
					    <td nowrap="nowrap" align="right" >密码:</td>
					    <td>
					    	<input name='password' id='password' type="password" class="text" style="width:154px" onblur="checkPassword();"/>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，不少于6位字符，不大于30位，不能包含空格</span>
			        		<span style="color:red;font-size:15px;" id="passwordSpan"></span>
			        	</td>
					  </tr>
					  <tr >
					    <td nowrap="nowrap" align="right" >密码确认:</td>
					    <td>
					    	<input name='confirmPassword' id='confirmPassword' type="password" class="text" style="width:154px" onblur="checkConfirmPassword()" />
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，请再次输入密码</span>
				        	<span style="color:red;font-size:15px;" id="confirmPasswordSpan"></span>
			        	</td>
					  </tr>
					  
					  <tr>
					  	<td class="information-sort">详细信息<span class="red" style="font-size:12px;">(*为必填项)</span></td>
					  </tr>
					  <tr>
					  	<td colspan="4" ><hr/></td>
					  </tr>
					  
					  <tr>
					     <td nowrap="nowrap" align="right" >姓名:</td>
					     <td><input name='name' id='name' type="text" class="text" style="width:154px" onblur="checkName()" />
				         <span class="red">* </span>
				         <span style="color:#2e3192;">必填，请填入真实姓名</span>
				         <span style="color:red;font-size:15px;" id="nameSpan"></span>
				         </td>
					   </tr>
					  
					   <tr>
					    <td align="right">性别:</td>
					    <td>
					    	<select name="sex" >
                            	<option value="男" selected="selected">男</option>
                            	<option value="女">女</option>
                        	</select>
                       	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">国家或地区:</td>
					    <td>
					    	<select name="country" >
					    		<option value="中国" selected="selected">中国CHINA</option>
                            	<option value="美国">美国UNITEDSTATES</option>
								<option value="阿根廷">阿根廷ARGENTINA</option>
								<option value="阿拉伯联合酋长国">阿拉伯联合酋长国ARAB</option>
								<option value="澳大利亚">澳大利亚AUSTRALIA</option>
								<option value="加拿大">加拿大CANADA</option>
								<option value="英国">英国UNITED KINGDOM</option>
								<option value="芬兰">芬兰FINLAND</option>
								<option value="法国">法国FRANCE</option>
								<option value="德国">德国GERMANY</option>
								<option value="荷兰">荷兰HOLLAND</option>
								<option value="匈牙利">匈牙利HUNGARY</option>
								<option value="冰岛">冰岛ICELAND</option>
								<option value="印度">印度INDIA</option>
								<option value="印度尼西亚">印度尼西亚INDONESIA</option>
								<option value="伊朗">伊朗IRAN</option>
								<option value="伊拉克">伊拉克IRAQ</option>
								<option value="日本">日本JAPAN</option>
								<option value="韩国">韩国KOREA</option>
								<option value="老挝">老挝LAOS</option>
								<option value="立陶宛">立陶宛LITHUANIA</option>
								<option value="卢森堡">卢森堡LUXEMBOURG</option>
								<option value="马来西亚">马来西亚MALAYSIA</option>
								<option value="马尔代夫">马尔代夫MALDIVES</option>
								<option value="哥斯达黎加">哥斯达黎加CostaRica</option>
                        	</select>
                       	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">证件类型:</td>
					    <td>
					    	<select name="papers_type" >
								<option value="身份证" selected="selected">身份证</option>
								<option value="港澳通行证">港澳通行证</option>
								<option value="台湾通行证">台湾通行证</option>
								<option value="护照">护照</option>
                        	</select>
                       	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">证件号码:</td>
					    <td>
					    	<input class="text" name='papers_num' id='papers_num' style="width:154px" onblur="checkpapersNum()"/>
					    	<span class="red">* </span>
					    	<span style="color:#2e3192;">必填，请填入正确的证件号码</span>
					    	<span style="color:red;font-size:15px;" id="paperNumSpan"></span>
					    </td>
					  </tr>
					  
					  <tr>
					  	<td class="information-sort">联系方式:<span class="red" style="font-size:12px;">(*为必填项)</span></td>
					  </tr>
					  <tr>
					  	<td colspan="4" ><hr/></td>
					  </tr>
					  
					  <tr>
					    <td align="right">手机号码:</td>
					    <td>
					    	<input class="text" name='phone' id='phone' style="width:154px" onblur="checkPhone()"/>
					    	<span class="red">* </span>
					    	<span style="color:#2e3192;">必填，请填入正确的手机号码</span>
					    	<span style="color:red;font-size:15px;" id="phoneSpan"></span>
					    </td>
					  </tr>
					  
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td>
					    	<input class="text" name='email' id='email' style="width:154px" onblur="checkEmail()"/>
				    		<span class="red">* </span>
				    		<span style="color:#2e3192;">必填，请填入正确的邮箱</span>
				    		<span style="color:red;font-size:15px;" id="emailSpan"></span>
				    	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">地址:</td>
					    <td><input name="address" type="text" /></td>
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
			<input type="submit" name="save" value="保存" class="button" />　
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

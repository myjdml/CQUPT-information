<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改用户信息</title>
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
	
	
	function checkit(){
		if(checkUsername()&&checkPassword()&&checkName()&&checkpapersNum()&&checkPhone()&&checkEmail()){
			return true;
		}else{
			return false;
		}
	}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="/graduate/UpdateUserServlet" method="post"  name="form1"  onsubmit="return checkit();">
	<input type="hidden" name="userId" value="${user.id}">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >用户信息修改</th>
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
					    <td><input name='username' id='username' type="text" class="text" style="width:154px" value="${user.username }" onblur="checkUsername();"/>
				         	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，由字母、数字或“_”组成，长度不少于6位，不多于30位</span>
				        	<span style="color:red;font-size:15px;" id="usernameSpan"></span>
				        </td>
					  </tr>
					  <tr >
					    <td nowrap="nowrap" align="right" >密码:</td>
					    <td><input name='password' id='password' type="text" class="text" style="width:154px" value="${user.password}" onblur="checkPassword();"/>
				        	<span class="red">* </span>
				        	<span style="color:#2e3192;">必填，不少于6位字符，不大于30位，不能包含空格</span>
			        		<span style="color:red;font-size:15px;" id="passwordSpan"></span>
				        </td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right" >用户身份:</td>
					    <td>
				        	<select name="status">
				        		<option value="1" <c:if test="${user.status eq 1 }">selected</c:if>>普通用户</option>
				        		<option value="2" <c:if test="${user.status eq 2 }">selected</c:if>>管理员</option>
				        	</select>
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
					     <td><input name='name' id='name' type="text" class="text" style="width:154px" value="${user.name}" onblur="checkName();"/>
				        	 <span class="red">* </span>
					         <span style="color:#2e3192;">必填，请填入真实姓名</span>
					         <span style="color:red;font-size:15px;" id="nameSpan"></span>
				         </td>
					   </tr>
					  
					   <tr>
					    <td align="right">性别:</td>
					    <td>
					    	<select name="sex" >
                            	<option value="男" <c:if test="${user.sex eq '男' }">selected</c:if> >男</option>
                            	<option value="女" <c:if test="${user.sex eq '女' }">selected</c:if> >女</option>
                        	</select>
                        	
                       	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">国家或地区:</td>
					    <td>
					    	<select name="country" >
					    		<option value="中国" <c:if test="${user.county eq '中国' }">selected</c:if> >中国CHINA</option>
                            	<option value="美国" <c:if test="${user.county eq '美国' }">selected</c:if> >美国UNITEDSTATES</option>
								<option value="阿根廷" <c:if test="${user.county eq '阿根廷' }">selected</c:if> >阿根廷ARGENTINA</option>
								<option value="阿拉伯联合酋长国" <c:if test="${user.county eq '阿拉伯联合酋长国' }">selected</c:if>>阿拉伯联合酋长国ARAB</option>
								<option value="澳大利亚" <c:if test="${user.county eq '澳大利亚' }">selected</c:if>>澳大利亚AUSTRALIA</option>
								<option value="加拿大" <c:if test="${user.county eq '加拿大' }">selected</c:if>>加拿大CANADA</option>
								<option value="英国" <c:if test="${user.county eq '英国' }">selected</c:if>>英国UNITED KINGDOM</option>
								<option value="芬兰" <c:if test="${user.county eq '芬兰' }">selected</c:if>>芬兰FINLAND</option>
								<option value="法国" <c:if test="${user.county eq '法国' }">selected</c:if>>法国FRANCE</option>
								<option value="德国" <c:if test="${user.county eq '德国' }">selected</c:if>>德国GERMANY</option>
								<option value="荷兰" <c:if test="${user.county eq '荷兰' }">selected</c:if>>荷兰HOLLAND</option>
								<option value="匈牙利" <c:if test="${user.county eq '匈牙利' }">selected</c:if>>匈牙利HUNGARY</option>
								<option value="冰岛" <c:if test="${user.county eq '冰岛' }">selected</c:if>>冰岛ICELAND</option>
								<option value="印度" <c:if test="${user.county eq '印度' }">selected</c:if>>印度INDIA</option>
								<option value="印度尼西亚" <c:if test="${user.county eq '印度尼西亚' }">selected</c:if>>印度尼西亚INDONESIA</option>
								<option value="伊朗" <c:if test="${user.county eq '伊朗' }">selected</c:if>>伊朗IRAN</option>
								<option value="伊拉克" <c:if test="${user.county eq '伊拉克' }">selected</c:if>>伊拉克IRAQ</option>
								<option value="日本" <c:if test="${user.county eq '日本' }">selected</c:if>>日本JAPAN</option>
								<option value="韩国" <c:if test="${user.county eq '韩国' }">selected</c:if>>韩国KOREA</option>
								<option value="老挝" <c:if test="${user.county eq '老挝' }">selected</c:if>>老挝LAOS</option>
								<option value="立陶宛" <c:if test="${user.county eq '立陶宛' }">selected</c:if>>立陶宛LITHUANIA</option>
								<option value="卢森堡" <c:if test="${user.county eq '卢森堡' }">selected</c:if>>卢森堡LUXEMBOURG</option>
								<option value="马来西亚" <c:if test="${user.county eq '马来西亚' }">selected</c:if>>马来西亚MALAYSIA</option>
								<option value="马尔代夫" <c:if test="${user.county eq '马尔代夫' }">selected</c:if>>马尔代夫MALDIVES</option>
								<option value="哥斯达黎加" <c:if test="${user.county eq '哥斯达黎加' }">selected</c:if>>哥斯达黎加CostaRica</option>
                        	</select>
                       	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">证件类型:</td>
					    <td>
					    	<select name="papers_type" >
								<option value="身份证" <c:if test="${user.papers_type eq '身份证' }">selected</c:if> >身份证</option>
								<option value="港澳通行证" <c:if test="${user.papers_type eq '港澳通行证' }">selected</c:if> >港澳通行证</option>
								<option value="台湾通行证" <c:if test="${user.papers_type eq '台湾通行证' }">selected</c:if> >台湾通行证</option>
								<option value="护照" <c:if test="${user.papers_type eq '护照' }">selected</c:if> >护照</option>
                        	</select>
                       	</td>
					  </tr>
					  
					  <tr>
					    <td align="right">证件号码:</td>
					    <td>
					    	<input class="text" name='papers_num' id='papers_num' type="text" style="width:154px" value="${user.papers_num}" onblur="checkpapersNum();"/>
					    	<span class="red">* </span>
					    	<span style="color:#2e3192;">必填，请填入正确的证件号码</span>
					    	<span style="color:red;font-size:15px;" id="paperNumSpan"></span>
				    	</td>
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
					    	<input class="text" name='phone' id='phone' type="text" style="width:154px" value="${user.phone}" onblur="checkPhone();"/>
					    		<span class="red">* </span>
					    		<span style="color:#2e3192;">必填，请填入正确的手机号码</span>
					    		<span style="color:red;font-size:15px;" id="phoneSpan"></span>
					    	</td>
					    </td>
					  </tr>
					  
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td>
					    	<input class="text" name='email' id='email' type="text" style="width:154px" value="${user.email}" onblur="checkEmail();"/>
					    	<span class="red">* </span>
				    		<span style="color:#2e3192;">必填，请填入正确的邮箱</span>
				    		<span style="color:red;font-size:15px;" id="emailSpan"></span>
			    		</td>
					    </td>
					  </tr>
					  
					  <tr>
					    <td align="right">地址:</td>
					    <td><input class="text" name="address" type="text" style="width:154px" value="${user.address}"/></td>
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

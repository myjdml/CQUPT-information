<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>铁路客运票务管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="/graduate/css/css.css" rel="stylesheet" type="text/css" />
<link href="/graduate/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style3 {font-size: 18px}
.style5 {font-size: 14px; text-decoration: none; font-family: "宋体";}
.style6 {font-size: 12px; height: 20px; width: 45px; background-image: url(../images/button04.gif); border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-family: "宋体";}
.style7 {font-size: 12px; height: 20px; width: 75px; background-image: url(../images/button09.gif); border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-family: "宋体";}
.style10 {color: #000000}
-->
</style>
</head>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="/graduate/images/nav04.gif" class="style10">
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="2" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;用户资料</td>
                    </tr>
                    <tr>
                    	<td colspan="2" class="information-sort">基本信息</td>
                    </tr>
                  <tr>
				    <td width="21%" height="20" align="right" bgcolor="#FFFFFF">用户名</td>
                    <td width="74%" bgcolor="#FFFFFF">${user.username}</td>
                    </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">用户密码</td>
                    <td bgcolor="#FFFFFF">${user.password }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">用户身份</td>
                    <td bgcolor="#FFFFFF">${user.status eq 1? "普通用户":"管理员" }</td>
                  </tr>
                  <tr>
                    	<td colspan="2" class="information-sort">详细信息</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">姓名</td>
                    <td bgcolor="#FFFFFF">${user.name }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">性别</td>
                    <td bgcolor="#FFFFFF">${user.sex }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">国家或地区</td>
                    <td bgcolor="#FFFFFF">${user.county }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">证件类型</td>
                    <td bgcolor="#FFFFFF">${user.papers_type }</td>
                   </tr>
                   <tr>
				    <td align="right" bgcolor="#FFFFFF">证件号码</td>
                    <td bgcolor="#FFFFFF">${user.papers_num }</td>
                   </tr>
                   <tr>
                    	<td colspan="2" class="information-sort">联系方式</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">手机号</td>
                    <td bgcolor="#FFFFFF">${user.phone }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">电子邮件</td>
                    <td bgcolor="#FFFFFF">${user.email }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">地址</td>
                    <td bgcolor="#FFFFFF">${user.address }</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
	 </td>
  </tr>
  <tr>
  	<td align="center" height="50px">
		<input type="button" name="back" id="back" onclick="window.history.go(-1);" value="返回"/>
	</td>
  </tr>
</table>
</form>
</body>
</html>
  </tr>
</table>
</form>
</body>
</html>

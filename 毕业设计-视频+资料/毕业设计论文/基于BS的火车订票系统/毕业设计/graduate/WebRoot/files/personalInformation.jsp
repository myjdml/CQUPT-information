<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sp.entity.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>铁路客运票务管理系统</title>

<link href="/graduate/css/css.css" rel="stylesheet" type="text/css" />
<link href="/graduate/css/style.css" rel="stylesheet" type="text/css" />

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
                    <td height="20" colspan="2" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;个人资料</td>
                    </tr>
                    <tr>
                    	<td colspan="2" class="information-sort">基本信息</td>
                    </tr>
                  <tr>
				    <td width="21%" height="20" align="right" bgcolor="#FFFFFF">用户名</td>
                    <td width="74%" bgcolor="#FFFFFF">${commonUsers.username}</td>
                    </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">用户密码</td>
                    <td bgcolor="#FFFFFF">${commonUsers.password }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">用户身份</td>
                    <td bgcolor="#FFFFFF">${commonUsers.status eq 1? "普通用户":"管理员" }</td>
                  </tr>
                  <tr>
                    	<td colspan="2" class="information-sort">详细信息</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">姓名</td>
                    <td bgcolor="#FFFFFF">${commonUsers.name }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">性别</td>
                    <td bgcolor="#FFFFFF">${commonUsers.sex }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">国家或地区</td>
                    <td bgcolor="#FFFFFF">${commonUsers.county }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">证件类型</td>
                    <td bgcolor="#FFFFFF">${commonUsers.papers_type }</td>
                   </tr>
                   <tr>
				    <td align="right" bgcolor="#FFFFFF">证件号码</td>
                    <td bgcolor="#FFFFFF">${commonUsers.papers_num }</td>
                   </tr>
                   <tr>
                    	<td colspan="2" class="information-sort">联系方式</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">手机号</td>
                    <td bgcolor="#FFFFFF">${commonUsers.phone }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">电子邮件</td>
                    <td bgcolor="#FFFFFF">${commonUsers.email }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">地址</td>
                    <td bgcolor="#FFFFFF">${commonUsers.address }</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
	 </td>
  </tr>
  <tr>
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

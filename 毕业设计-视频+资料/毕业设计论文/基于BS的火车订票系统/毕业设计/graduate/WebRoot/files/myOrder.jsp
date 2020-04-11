<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>铁路客运票务管理系统</title>

<link href="/graduate/css/css.css" rel="stylesheet" type="text/css" />
<link href="/graduate/css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<form name="fom" id="fom" method="post" action="/graduate/DoBuyTicketServlet">
<input type="hidden" name="user_id" value="${order.user_id}"/>
<input type="hidden" name="train_num" value="${order.train_num}"/>
<input type="hidden" name="leaveTime" value="${order.leaveTime }"/>
<input type="hidden" name="origin" value="${order.origin }"/>
<input type="hidden" name="terminus" value="${order.terminus }"/>
<input type="hidden" name="g_time" value="${order.g_time }"/>
<input type="hidden" name="a_time" value="${order.a_time }"/>
<input type="hidden" name="price" value="${order.price }"/>
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
                    <td height="20" colspan="2" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;订单信息</td>
                    </tr>
                    <tr>
                    	<td colspan="2" class="information-sort">车次信息</td>
                    </tr>
                  <tr>
				    <td width="21%" height="20" align="right" bgcolor="#FFFFFF">车次</td>
                    <td width="74%" bgcolor="#FFFFFF">${order.train_num}</td>
                    </tr>
                   <tr>
                    <td align="right" bgcolor="#FFFFFF">出发日期</td>
                    <td bgcolor="#FFFFFF">${order.leaveTime }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">起点站</td>
                    <td bgcolor="#FFFFFF">${order.origin }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">终点站</td>
                    <td bgcolor="#FFFFFF">${order.terminus }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">发车时间</td>
                    <td bgcolor="#FFFFFF">${order.g_time }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">到站时间</td>
                    <td bgcolor="#FFFFFF">${order.a_time }</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">票价</td>
                    <td bgcolor="#FFFFFF">${order.price }</td>
                  </tr>
                  
                  <tr>
                    	<td colspan="2" class="information-sort">旅客信息</td>
                  </tr>
                  <tr>
                    <td align="right" bgcolor="#FFFFFF">姓名</td>
                    <td bgcolor="#FFFFFF">${commonUsers.name }</td>
                  </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">证件类型</td>
                    <td bgcolor="#FFFFFF">${commonUsers.papers_type }</td>
                   </tr>
                   <tr>
				    <td align="right" bgcolor="#FFFFFF">证件号码</td>
                    <td bgcolor="#FFFFFF">${commonUsers.papers_num }</td>
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
  <TR>
	<TD colspan="2" align="center" height="50px">
	<input type="submit" name="save" value="确定购买" class="button"/>　
	<input type="button" name="return" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
</TR>
</table>
</form>
</body>
</html>
  </tr>
</table>
</form>
</body>
</html>

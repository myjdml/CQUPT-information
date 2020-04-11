<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>铁路客运票务管理系统</title>

<link href="/graduate/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
</script>
<link href="/graduate/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>


<form name="fom" id="fom" method="post" action="/graduate/GetTrainServlet">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>    
          <td height="62" background="/graduate/images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="/graduate/images/ico07.gif" width="20" height="18" /></td>
			  <td width="519">
			  车次：<input name="train_num" type="text" size="12" value="${train.train_num}"/>
			   <input name="select_train" type="submit" class="right-button02" value="查 询" /></td>
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title" >车次查询</td>
                    </tr>
                  <tr>
					<td  align="center" bgcolor="#EEEEEE">站序</td>
                    <td  align="center" bgcolor="#EEEEEE">车站</td>
                    <td  align="center" bgcolor="#EEEEEE">车次</td>
					<td  align="center" bgcolor="#EEEEEE">到站时间</td>
					<td  align="center" bgcolor="#EEEEEE">发车时间</td>
					<td  align="center" bgcolor="#EEEEEE">票价</td>
					<td  align="center" bgcolor="#EEEEEE">额定票数</td>
					<td  align="center" bgcolor="#EEEEEE">剩余票数</td>
                  </tr>
                  <c:if test="${requestScope.station != null}">
				  
				  <c:forEach var="i" begin="0" end="${requestScope.length -1}" step="1">
                  <tr>
					<td align="center" bgcolor="#FFFFFF">${i+1}</td>
                    <td align="center" bgcolor="#FFFFFF">${station[i] }</a></td>
                    <td align="center" bgcolor="#FFFFFF">${train.train_num }</td>
                    <td align="center" bgcolor="#FFFFFF">${a_time[i] }</td>
                    <td align="center" bgcolor="#FFFFFF">${g_time[i]}</td>
                    <td align="center" bgcolor="#FFFFFF">${price[i] }</td>
					<td align="center" bgcolor="#FFFFFF">${train.amount}</td>
					<td align="center" bgcolor="#FFFFFF">${train.remainder }</td>
                  </tr>
                  </c:forEach>
                  </c:if>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
  </tr>
  
</table>
</form>
</body>
</html>
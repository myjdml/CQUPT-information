<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>车次管理</title>


<link href="/graduate/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function jump(p){
		var oForm = document.fom || document.forms[0];
		oForm.currentPage.value=p;
		oForm.submit();
	}
	function checnNum(){
		var goTo = document.getElementById("goTo").value;
		var checkNum = /^\d+$/; //检查输入的是否为数字
		if(checkNum.test(goTo)==false){
			jump(1);
		}else{
		jump(document.getElementById('goTo').value);
		}
	}
	
	
</script>
<link href="/graduate/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form name="fom" id="fom" method="post" action="/graduate/GetTrainsServlet">
<input type="hidden" name="currentPage" value="${pb.currentPage}"/>
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
			  车次：<input name="train_num" type="text" size="12" value="${condition.train_num}"/>
			   <input name="select_user" type="submit" class="right-button02" value="查 询" /></td>
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
                    <td height="20" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;用户列表 &nbsp;</td>
                    </tr>
                 <tr>
					<td  align="center" bgcolor="#EEEEEE">序号</td>
                    <td  align="center" bgcolor="#EEEEEE">车次</td>
                    <td  align="center" bgcolor="#EEEEEE">始发站</td>
                    <td  align="center" bgcolor="#EEEEEE">终点站</td>
					<td  align="center" bgcolor="#EEEEEE">发车时间</td>
					<td  align="center" bgcolor="#EEEEEE">到站时间</td>
					<td  align="center" bgcolor="#EEEEEE">全程票价</td>
					<td  align="center" bgcolor="#EEEEEE">额定票数</td>
					<td  align="center" bgcolor="#EEEEEE">剩余票数</td>
					<td  align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:if test="${requestScope.listStation ne null}">
                  <c:forEach items="${requestScope.listStation}" var="station" varStatus="s">
                  <tr>
					<td  align="center" bgcolor="#FFFFFF">${s.index+1 }</td>
                    <td  align="center" bgcolor="#FFFFFF"><a href="/graduate/GetTrainServlet?train_num=${station.train_num }" style="color:blue;">${station.train_num }</a></td>
                    <td  align="center" bgcolor="#FFFFFF">${station.start }</td>
                    <td  align="center" bgcolor="#FFFFFF">${station.end }</td>
					<td  align="center" bgcolor="#FFFFFF">${station.g_time }</td>
					<td  align="center" bgcolor="#FFFFFF">${station.a_time }</td>
					<td  align="center" bgcolor="#FFFFFF">${station.price }</td>
					<td  align="center" bgcolor="#FFFFFF">${station.amount }</td>
					<td  align="center" bgcolor="#FFFFFF">${station.remainder }</td>
                    <td align="center" bgcolor="#FFFFFF">
                    	<a href="/graduate/ToUpdateTrainServlet?train_num=${station.train_num}" style="color:blue;">编辑</a>
                    	/<a style="color:blue;" href="javascript:if(confirm('您确定要删除吗？')){window.location.href='/graduate/DeleteTrainServlet?train_num=${station.train_num}'}">删除</a>
                   	</td>
                  </tr>
                  </c:forEach>
                  </c:if>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
		<td style="text-align: left"> 
			第<font color="red">${pb.currentPage}</font>/${pb.totalPage}页
			共${pb.totalCount}条
		</td>
		<td style="text-align:right" >
			<c:choose>
				<c:when test="${pb.currentPage eq 1}">
					首页
					上一页
				</c:when>
				<c:otherwise>
					<a href="javascript:jump(1)" style="color:blue;">首页</a>
					<a href="javascript:jump(${pb.currentPage-1})" style="color:blue;">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pb.currentPage eq pb.totalPage}">
					下一页
					末页
				</c:when>
				<c:otherwise>
					<a href="javascript:jump(${pb.currentPage+1})" style="color:blue;" >下一页</a>
					<a href="javascript:jump(${pb.totalPage})" style="color:blue;">末页</a>
				</c:otherwise>
			</c:choose>
			转到<input id="goTo" type="text" style="width:20px" value="${pb.currentPage }" />页
			<input type="button" value="GO" onclick="checnNum()" />
		</td>
	</tr>
		
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��·����Ʊ�����ϵͳ</title>

<link href="/graduate/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function jump(p){
		var oForm = document.searchForm || document.forms[0];
		oForm.currentPage.value=p;
		oForm.submit();
	}
	function checnNum(){
		var goTo = document.getElementById("goTo").value;
		var checkNum = /^\d+$/; //���������Ƿ�Ϊ����
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
<form name="fom" id="fom" method="post" action="/graduate/GetMyOrderServlet">
<input type="hidden" name="currentPage" value="${pb.currentPage}"/>
<input type="hidden" name="user_id" value="${commonUsers.id }"/>
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
			 ���Σ�<input name="train_num" type="text" size="12" value="${condition.train_num}"/>
			   <input name="select_train" type="submit" class="right-button02" value="�� ѯ" /></td>
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
                    <td height="20" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;�ҵĶ��� &nbsp;</td>
                    </tr>
                   <tr>
                 	<td  align="center" bgcolor="#EEEEEE">���</td>
					<td  align="center" bgcolor="#EEEEEE">������</td>
                    <td  align="center" bgcolor="#EEEEEE">����</td>
                    <td  align="center" bgcolor="#EEEEEE">��������</td>
                    <td  align="center" bgcolor="#EEEEEE">�µ�����</td>
                    <td  align="center" bgcolor="#EEEEEE">���վ</td>
					<td  align="center" bgcolor="#EEEEEE">�յ�վ</td>
					<td  align="center" bgcolor="#EEEEEE">����ʱ��</td>
					<td  align="center" bgcolor="#EEEEEE">��վʱ��</td>
					<td  align="center" bgcolor="#EEEEEE">Ʊ��</td>
					<td  align="center" bgcolor="#EEEEEE">����</td>
                  </tr>
                  <c:if test="${requestScope.list ne null}">
                  <c:forEach items="${requestScope.list}" var="order" varStatus="s">
                  <tr>
					<td  align="center" bgcolor="#FFFFFF">${s.index+1 }</td>
                    <td  align="center" bgcolor="#FFFFFF"><a href="/graduate/GetOrderServlet?order_id=${order.id }" style="color:blue;">${order.id }</a></td>
                    <td  align="center" bgcolor="#FFFFFF">${order.train_num }</td>
                    <td  align="center" bgcolor="#FFFFFF">${order.leaveTime }</td>
                    <td  align="center" bgcolor="#FFFFFF">
						<fmt:formatDate value="${order.order_time}" pattern="yyyy-MM-dd"/>
					</td>
					<td  align="center" bgcolor="#FFFFFF">${order.origin }</td>
					<td  align="center" bgcolor="#FFFFFF">${order.terminus }</td>
					<td  align="center" bgcolor="#FFFFFF">${order.g_time }</td>
					<td  align="center" bgcolor="#FFFFFF">${order.a_time }</td>
					<td  align="center" bgcolor="#FFFFFF">${order.price }</td>
                    <td align="center" bgcolor="#FFFFFF">
                    	<a style="color:blue;" href="javascript:if(confirm('��ȷ��Ҫ��Ʊ��')){window.location.href='/graduate/ReturnTicketServlet?order_id=${order.id}&train_num=${order.train_num }&user_id=${order.user_id }'}">��Ʊ</a>
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
			��<font color="red">${pb.currentPage}</font>/${pb.totalPage}ҳ
			��${pb.totalCount}��
		</td>
		<td style="text-align:right" >
			<c:choose>
				<c:when test="${pb.currentPage eq 1}">
					��ҳ
					��һҳ
				</c:when>
				<c:otherwise>
					<a href="javascript:jump(1)" style="color:blue;">��ҳ</a>
					<a href="javascript:jump(${pb.currentPage-1})" style="color:blue;">��һҳ</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pb.currentPage eq pb.totalPage}">
					��һҳ
					ĩҳ
				</c:when>
				<c:otherwise>
					<a href="javascript:jump(${pb.currentPage+1})" style="color:blue;" >��һҳ</a>
					<a href="javascript:jump(${pb.totalPage})" style="color:blue;">ĩҳ</a>
				</c:otherwise>
			</c:choose>
			ת��<input id="goTo" type="text" style="width:20px" value="${pb.currentPage }" />ҳ
			<input type="button" value="GO" onclick="checnNum()" />
		</td>
	</tr>
		
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
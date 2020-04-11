<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>铁路客运票务管理系统</title>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="../images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="../images/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="../images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="../images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="../images/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="../images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="../images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01"><span class="left-font02">${sessionScope.welcome}${sessionScope.username}</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="../login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >车次管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="addTrain.jsp" target="mainFrame" class="left-font03" onClick="tupian('20');">车次录入</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiaotu21" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="/graduate/GetTrainsServlet" target="mainFrame" class="left-font03" onClick="tupian('21');">车次管理</a></td>
				</tr>
      </table>

		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >车次查询</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
				  <td width="9%" height="20" ><img id="xiaotu24" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="/graduate/files/listTrain.jsp" target="mainFrame" class="left-font03" onClick="tupian('24');">车次查询</a></td>
			</tr>
      </table>

		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >购&nbsp;&nbsp;&nbsp;&nbsp;票</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu24" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="/graduate/buyTicket/buyTicket.jsp" target="mainFrame" class="left-font03" onClick="tupian('24');">购&nbsp;&nbsp;&nbsp;&nbsp;票
							</a></td>
				</tr>
      </table>



        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >退&nbsp;&nbsp;&nbsp;&nbsp;票</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
			<tr>
				  <td width="9%" height="20" ><img id="xiaotu24" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="/graduate/GetMyOrderServlet?user_id=${commonUsers.id }" target="mainFrame" class="left-font03" onClick="tupian('24');">退&nbsp;&nbsp;&nbsp;&nbsp;票
							</a></td>
			</tr>	
      </table>
		

	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img3" id="img3" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');" >用户管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20" ><img id="xiaotu8" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="addUser.jsp" target="mainFrame" class="left-font03" onClick="tupian('8');">添加用户</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiaotu8" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="/graduate/GetUsersServlet" target="mainFrame" class="left-font03" onClick="tupian('8');">管理用户</a></td>
        </tr>
      </table>
	
	 
	   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img4" id="img4" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('4');" >订单管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree4" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
		<tr>
          <td width="9%" height="20" ><img id="xiaotu11" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="/graduate/GetMyOrderServlet?user_id=${commonUsers.id }" target="mainFrame" class="left-font03" onClick="tupian('11');">我的订单</a></td>
        </tr>
	  	<tr>
          <td width="9%" height="20" ><img id="xiaotu12" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="/graduate/GetAllOrderServlet" target="mainFrame" class="left-font03" onClick="tupian('12');">所有订单</a></td>
        </tr>
      </table>


		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img9" id="img9" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('9');" >个人管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>

		<table id="subtree9" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="22" ><img id="xiaotu22" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
				  	<a href="/graduate/files/personalInformation.jsp" target="mainFrame" class="left-font03" onClick="tupian('22');">查看个人信息</a>
				 </td>
				</tr>
				<tr>
				  <td width="9%" height="23" ><img id="xiaotu23" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="/graduate/files/updatePersonInformation.jsp" target="mainFrame" class="left-font03" 
						onClick="tupian('23');">修改个人信息</a></td>
				</tr>
				<tr>
				  <td width="9%" height="23" ><img id="xiaotu23" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="/graduate/files/updatePassword.jsp" target="mainFrame" class="left-font03" 
						onClick="tupian('23');">修&nbsp;&nbsp;改&nbsp;&nbsp;密&nbsp;&nbsp;码</a></td>
				</tr>
      </table>

	  <!--
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
        <tr>
          <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="8%"><img name="img6" id="img6" src="../images/ico04.gif" width="8" height="11" /></td>
                <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('6');">系统帮助</a></td>
              </tr>
          </table></td>
        </tr>
      </table>
	  <table id="subtree6" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20"><img id="xiaotu15" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="/graduate/files/userHandbook.jsp" target="mainFrame" class="left-font03" onClick="tupian('15');">用户手册</a></td>
        </tr>
        <tr>
          <td height="20"><img id="xiaotu16" src="../images/ico06.gif" width="8" height="12" /></td>
          <td><a href="/graduate/files/rules.jsp" target="mainFrame" class="left-font03" onClick="tupian('16');">规章制度</a></td>
        </tr>
      </table>
	  -->

	  </TD>
  </tr>
  
</table>
</body>
</html>

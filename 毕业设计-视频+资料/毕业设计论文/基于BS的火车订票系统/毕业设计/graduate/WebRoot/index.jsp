<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>铁路客运票务管理系统</title>
</head>

<frameset rows="188,*" cols="*" frameborder="no" border="0" framespacing="0" >
  <frame src="files/admin_top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frameset cols="213,*" frameborder="no" border="0" framespacing="0">
    <c:choose>
    <c:when test="${status eq 2}">
    <frame src="files/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
   	</c:when>
   	<c:otherwise>
   	<frame src="files/left1.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
   	</c:otherwise>
    </c:choose>
    <frame src="files/mainfra.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>

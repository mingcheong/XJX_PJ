<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1);
%>
<html>
<title>运行时异常信息！</title>
<body>
	<span style="font-size:22px;"> 异常提示：</span><br>
	<font color="red"><s:property value="%{exception}"/></font>
</body>
</html>
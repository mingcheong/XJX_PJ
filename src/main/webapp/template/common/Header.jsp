<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%>
<%@ taglib prefix="jmesa" uri="/WEB-INF/tld/jmesa.tld"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1);
%>
<html>
<head>
<fmt:setBundle basename="ApplicationResources" />
<title>安全科技－J2EE平台快速开发平台！</title>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jmese/js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jmese/js/jquery.jmesa.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jmese/js/jmesa.min.js"></script>
<link rel="stylesheet" href='${pageContext.request.contextPath}/resources/default/css.css' type="text/css">
<link rel="stylesheet" href='${pageContext.request.contextPath}/resources/jmese/css/jmesa.css' type="text/css">
<script>jQuery.noConflict();</script>
</head>
<body class="" leftmargin="0" rightmargin="0" topmargin="0" bottommargin="0" oncontextmenu="return true" style="width: 100%">
<table width='100%' height="100%" cellspacing="0" cellpadding="0" border="0">
<tr valign='top'>
<s:password n></s:password>
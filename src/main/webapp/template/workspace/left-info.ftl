<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" type="text/css" href="${resourcePath}/default/css/style.css" />
<title>无标题文档</title>
<style>
.btcontent a{font-size:18px}
.btcontent table tr td{
font-family:Arial, Helvetica, sans-serif;color:#5494af;font-size:13;
}
</style>
</head>

<body class="bodyleft">
<table width="190" border="0" class="leftcontent" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="36" width="190" class="lefttop1" ><table width="188" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td style=" font-size:12px; color:#000000;" align="center">今天是${cuurentDate?string("yyyy年MM月dd日")}</td>
  </tr>
</table>
</td>
  </tr>
  <tr>
    <td  height="190" class="leftmain" valign="top" >
		<div class="bt1">当前用户信息</div>
		<div class="btcontent">
			<table width="100%" cellpadding="0" cellspacing="0">
			<tr><td>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：${currentUser.fkOrganize.orgName?default('')}</td></tr>
			<tr><td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${currentUser.truename?default('')}</td></tr>
			<tr><td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：${currentUser.sex?default('')}</td></tr>
			<tr><td>联系电话：${currentUser.userPhone?default('')}</td></tr>
			</table>
			<span>祝您工作愉快！</span><br>
		</div>
		<div class="bt1">快捷通道</div>
		<table width="187" border="0" cellpadding="0" cellspacing="0" align="center" class="kjtd">
		  <tr>
		    <td width="43" style="text-align:center"><img src="${resourcePath}/default/images/wlt.gif"></td>
		    <td width="143"><a href="fkOrganize_chart.xhtml" target="mainFrame">组织架构图</a></td>
		  </tr>
		  <tr>
		    <td width="43" style="text-align:center"><img src="${resourcePath}/default/images/txl.gif"></td>
		    <td width="143"><a href="fkUser_contact.xhtml" target="mainFrame">通讯录</a></td>
		  </tr>
		</table>	
    <td  height="10" class="leftfoot" >&nbsp;</td>
  </tr>
</table>
</body>
</html>
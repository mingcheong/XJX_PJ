<%@ page contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%><%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><title>滁州市公共安全监管平台!</title>
<script src="resources/javascript/global/jquery-1.7.1.min.js" type="text/javascript"></script>
<script>jQuery.noConflict();</script></head><body>
<style type="text/css">
body {
	background-image: url(resources/default/images/login_bg.jpg);
	background-position: left top;
	background-repeat: repeat-x;
	margin: 0px auto;
	padding: 0px;
	overflow-x: hidden;
	overflow-y: auto;
}

table {
	font-size: 12px;
	color: #236ac8
}

img {
	border: none
}

.login td {
	padding: 3px
}

.login th {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 14px;
	text-align: right
}
</style>
<table width="1000" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td colspan="2"><img src="resources/default/images/login_01.jpg" width="1000" height="105"></td>
	</tr>
	<tr>
		<td colspan="2"><img src="resources/default/images/login_02.jpg" width="1000" height="75"></td>
	</tr>
	<tr>
		<td><img src="resources/default/images/login_03.jpg" width="432" height="165"></td>
		<td width="568" background="resources/default/images/login_04.jpg">
		<form id="loginForm" name="loginForm" action="dispatch.xhtml" method="post" style="padding:0; margin:0">
		<table width="100%" border="0" cellspacing="5" cellpadding="0" class="login">
			<tr>
				<td rowspan="3" width="80">&nbsp;</td>
				<th width="75">用户名：</th>
				<td width="165"><input type="text" style="width: 150px" id="userName" maxlength="20" name='username' onKeyDown="doNextInput(event,this.form.userPass);" /></td>
				<td rowspan="3" valign="top"><a href="javascript:void(0);"><img src="resources/default/images/denglu.jpg" width="66" height="66" id="loginButton"/></a></td>
			</tr>
			<tr>
				<th>密 码：</th>
				<td><input type="password" style="width: 150px" id="userPass" name='password' maxlength="16" onKeyDown="doNextInput(event,this.form.checkNumber);" />
				</div>
				</td>
			</tr>
			<tr>
				<th>验证码：</th>
				<td><input type="text" size="3" maxlength="4" style="margin-right: 25px" id="checkNumber" name="randcode" onKeyDown="doSubmit(event);" style="ime-mode:disabled" />
					<a href="javascript:document.getElementById('checkImg').setAttribute('src','random.xhtml?s='+Math.random());" title="点击换一张" onclick=""><img id="checkImg" src="random.xhtml" border="0" width="60" height="20" /></a></td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
	<tr>
		<td colspan="2"><img src="resources/default/images/login_05.jpg" width="1000" height="137"></td>
	</tr>
	<tr>
		<td colspan="2" align="center" style="line-height: 1.8">滁州市安全生产监督管理局<br>
		<a href="http://www.safetys.cn" target="_blank" style="color: #236ac8">技术支持：安生科技</a>联系电话：0574-87364008</td>
	</tr>
</table></body></html>
<script language="javascript">
if(window.top != window){//当登陆页被框架包含时，用top跳转到登陆页
	window.top.location.href = "index.jsp";
}
document.getElementById("userName").focus();
<c:if test="${not empty message}">
alert("用户、密码或验证码输入有误,请重试!");
</c:if>
<c:if test="${not empty ActionErrors}">
alert('${ActionErrors[0]}');
</c:if>
function doClickEvent(obj){
  if (document.all){//IE
         obj.fireEvent('onclick');
     }else{//FF
         var evt = document.createEvent("MouseEvents");
         evt.initEvent("click", true, true);
         obj.dispatchEvent(evt);
  }
}
function doSubmit(event){
    event=event?event:(window.event?window.event:null);
	if (event.keyCode==13){
          doClickEvent(document.getElementById("loginButton"));
	}
	return;
}
function trimAll(data){
  var reg=/^ +| +$/g;
  var str=data.replace(reg,"");
  return str;
}
function checkInput(){
	if(trimAll(document.getElementById("userName").value)==""){
		alert("      用户名不能为空！");
		document.getElementById("userName").focus();
		return false;
	}else if(trimAll(document.getElementById("userPass").value)==""){
		alert("      密码不能为空！");
		document.getElementById("userPass").focus();
		return false;
	}else if(trimAll(document.getElementById("checkNumber").value)==""){
		alert("      验证码不能为空！");
		document.getElementById("checkNumber").focus();
		return false;
	}
	return true;
}
function doNextInput(event,obj){
	event=event?event:(window.event?window.event:null);
	if (event.keyCode==13){
		obj.focus();
	}
	return;
}
jQuery("#loginButton").click(function(){
	if(checkInput()){
		loginForm.submit();
	}
});
</script>
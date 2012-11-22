<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script language="javascript">
var flag = true;
function shift_status()
{
	var _top = top.document.getElementById('main');
	var img = top.control.document.getElementById("menuSwitch1");
	if(flag){
		_top.cols = "0,6,*";
		document.all.menuSwitch1.src='${resourcePath}/default/images/13x79_2.gif';
		document.all.menuSwitch1.title='显示';
	}else{
		_top.cols = "195,6,*";
		document.all.menuSwitch1.src='${resourcePath}/default/images/13x79.gif';
		document.all.menuSwitch1.title='隐藏';
	}
	flag = !flag;
}
</script>

<style>
*{margin:0px;padding:0px;}
body{padding:0;margin:0}
</style>
</HEAD>

<body onclick="shift_status()">
<span class="cacher" id="cacheData" name="cacheData"></span>
<table width="6" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#f5fafe">
  <tr>
    <td height="157" valign="top"><img src="${resourcePath}/default/images/13x157.gif" width="6" ></td>
  </tr>
  <tr>
    <td height="70" background="${resourcePath}/default/images/13.gif"></td>
  </tr>
  <tr>
    <td height="79" id=menuSwitch style="cursor:hand"><img src="${resourcePath}/default/images/13x79.gif" width="6" id=menuSwitch1></td>
  </tr>
  <tr>
    <td background="${resourcePath}/default/images/13.gif"></td>
  </tr>
</table>
</body>
</HTML>





<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${resourcePath}/default/css/mainFrame.css" rel="stylesheet" type="text/css" />
<script src="${resourcePath}/javascript/global/jquery-1.7.1.min.js" type="text/javascript"></script>
<title>功能菜单</title></head><script type="text/javascript">function ShowMenu(obj,noid){var block=document.getElementById(noid);var n=noid.substr(noid.length-1);if(noid.length>8){var ul=document.getElementById(noid).getElementsByTagName("ul");var h2=document.getElementById(noid).getElementsByTagName("h2");for(var i=0;i<h2.length;i++){h2[i].style.color=""}obj.style.color="#003399";for(var i=0;i<ul.length;i++){if((i+1)!=n){ul[i].className="no"}}}else{var span=document.getElementById("menu").getElementsByTagName("span");var h1=document.getElementById("menu").getElementsByTagName("h1");for(var i=0;i<h1.length;i++){h1[i].style.color=""}obj.style.color="#003399";for(var i=0;i<span.length;i++){if(i!=n){span[i].className="no"}}}if(block.className=="no"){block.className="";obj.innerHTML=obj.innerHTML.replace("+","-")}else{block.className="no";obj.style.color=""}}function windowHeight(){var de=document.documentElement;return self.innerHeight||(de&&de.clientHeight)||document.body.clientHeight}window.onload=window.onresize=function(){var wh=windowHeight();document.getElementById("contentWrap").style.height=(wh-document.getElementById("lefttop").offsetHeight-document.getElementById("leftfoot").offsetHeight)+"px"}</script>
<body scroll="no" class="bodyleft">
<div id="wrap">
	<div id="lefttop""><span><img src="${resourcePath}/default/images/toplist.gif" /></span><span>菜单管理</span></span></div>
		<div id="contentWrap">
			<div id="mainleft" style="background:url(${resourcePath}/default/images/bg-0309.gif) repeat;">
				<div id="menu">
					${htmlMenus?default('')}
				</div>
			</div>
		</div>
	<div id="leftfoot"></div>
</div>
</body>
</html>
<@fkMacros.pageHeader />
<style type="text/css">
</style>
<script>
	function windowHeight() {
	    var de = document.documentElement;
	    return self.innerHeight||(de && de.clientHeight)||document.body.clientHeight;
	}
	window.onload=window.onresize=function(){
	var wh=windowHeight();
	document.getElementById("contentWrap").style.height = (wh-document.getElementById("lefttop").offsetHeight-document.getElementById("leftfoot").offsetHeight)+"px";
	}
</script>
<div id="wrap">
	<div id="lefttop" style="height:0px; overflow:hidden"></div>
	<div id="contentWrap" align="center">
	<img src="${resourcePath}/default/img/welcome.jpg" width="950" height="531" />
	</div>
	<div id="leftfoot" style="height:0px; overflow:hidden"></div>
</div>
<@fkMacros.pageFooter />
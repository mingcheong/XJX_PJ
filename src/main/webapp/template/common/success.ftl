<html>
<body>
	<div style="width: 100%; height: 100%; text-align: center;">
		<div>${message }</div>
		<div>
			页面将在 <span id="sec">3</span>秒内返回
		</div>
		<div>

		</div>
	</div>
	<script type="text/javascript">
		<#--var i = 3;
		function subSec() {
			i--;
			if (i <= 0) {
				window.location.href = ("${url}" == "null" || "${url}" == "") ? "#" : "${url}";
			} else {
				setTimeout("subSec()", 1000);
			}
			document.getElementById("sec").innerHTML = i;
		}
		subSec();-->
		window.location.href = ("${url}" == "null" || "${url}" == "") ? "#" : "${url}";
	</script>
</body>
</html>
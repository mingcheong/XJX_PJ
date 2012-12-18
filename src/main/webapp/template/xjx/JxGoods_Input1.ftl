<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ComboGrid - jQuery EasyUI Demo</title>
			<link href="${resourcePath}/default/css/css.css" rel="stylesheet" type="text/css" />
			<link href="${resourcePath}/default/css/data.css" rel="stylesheet" type="text/css" />
			<link href="${resourcePath}/datepicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
			<link href="${resourcePath}/jmesa/css/jmesa.css" rel="stylesheet" type="text/css" />
			<link href="${resourcePath}/themes/default/easyui.css" rel="stylesheet" type="text/css" />
			<link href="${resourcePath}/themes/icon.css" rel="stylesheet" type="text/css" />
			<script src="${resourcePath}/javascript/global/jquery-1.8.0.min.js" type="text/javascript"></script>
			<script src="${resourcePath}/javascript/global/jquery.easyui.min.js" type="text/javascript"></script>
			<script src="${resourcePath}/javascript/global/easyui-lang-zh_CN.js" type="text/javascript"></script>
			<script src="${resourcePath}/javascript/global/jquery.form.js" type="text/javascript"></script>
			<script src="${resourcePath}/datepicker/WdatePicker.js" type="text/javascript"></script>
			<script src="${resourcePath}/javascript/global/public.js" type="text/javascript"></script>
			<script src="${resourcePath}/javascript/global/common.js" type="text/javascript"></script>
			<script src="${resourcePath}/jmesa/js/jmesa.min.js" type="text/javascript"></script>
			<script src="${resourcePath}/jmesa/js/jquery.jmesa.min.js" type="text/javascript"></script>
			<script></script>
	</head>
	<link rel="stylesheet" type="text/css" href="${resourcePath}/loading/style.css" /><script src="${resourcePath}/loading/loading.js"></script><div id="loading"><div class="loading-indicator">页面正在加载中...</div></div>
	<body>

	<script>
	
		$(function(){
			$('#cc').combogrid({
				panelWidth:450,
				value:'006',

				idField:'code',
				textField:'name',
				url:'http://localhost:8080/XJX_PJ/resources/javascript/global/datagrid_data.json',
				columns:[[
					{field:'code',title:'Code',width:60},
					{field:'name',title:'Name',width:100},
					{field:'addr',title:'Address',width:120},
					{field:'col4',title:'Col41',width:100}
				]]
			});
		});
		function reload(){
			$('#cc').combogrid('grid').datagrid('reload');
		}
		function setValue(){
			$('#cc').combogrid('setValue', '002');
		}
		function getValue(){
			var val = $('#cc').combogrid('getValue');
			alert(val);
		}
		function disable(){
			$('#cc').combogrid('disable');
		}
		function enable(){
			$('#cc').combogrid('enable');
		}
	</script>

	<h2>ComboGrid</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Click the right arrow button to show the datagrid.</div>
	</div>
	
	<div style="margin:10px 0;">
		<a href="#" class="easyui-linkbutton" onclick="reload()">Reload</a>
		<a href="#" class="easyui-linkbutton" onclick="setValue()">SetValue</a>
		<a href="#" class="easyui-linkbutton" onclick="getValue()">GetValue</a>
		<a href="#" class="easyui-linkbutton" onclick="disable()">Disable</a>
		<a href="#" class="easyui-linkbutton" onclick="enable()">Enable</a>
	</div>
	<select id="cc" name="dept" style="width:250px;"></select>
</body>
</html>
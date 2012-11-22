<@fkMacros.pageHeader />
	<link rel="stylesheet" type="text/css" href="${resourcePath}/jOrgChart/css/custom.css" />
	<link rel="stylesheet" type="text/css" href="${resourcePath}/jOrgChart/css/jquery.jOrgChart.css" />
	<script src="${resourcePath}/jOrgChart/jquery.jOrgChart.js" type="text/javascript"></script>
	<style>
		body{text-align:center;margin:0px auto; padding:0px;color:black}
	
		.jOrgChart .node {
			background			: url(${resourcePath}/default/img/a.gif) center center;
		}
		.jOrgChart .nodeLevel_1 {
			background			: url(${resourcePath}/default/img/c.gif) center center;
		}
	</style>
</head>



<script type="text/javascript"> 

	jQuery(document).ready(function(){
		
		var str = "${organXml}";
		if("" != str & null != str)
		{
			var xml = getXMLObj(str);
	
			var tree=jQuery(xml).find("root").children("tree");
			if(parseInt(jQuery(tree).attr("size"))>0)
			{
				var chartHtml = '<ul id="org" style="display:none">';
				chartHtml = treeChart(chartHtml,tree,true);
				chartHtml+='</ul>';
				
				jQuery('body').append(chartHtml); //将生成结构html添加到body
				
	
				 jQuery("#org").jOrgChart({		//生成orgChat组件的视图
					chartElement : '#chart'
				});
			}else{
				var strMsg ="<div style='position:relative;font-size:14px;color:#245d8a;font-weight:bold;top:100px'>您好, " 
						   +jQuery(tree).attr("name") 
						   + "下暂无内部机构数据!</div>";
				jQuery("#chart").append(strMsg);
			}
		}
		
	});
	
	function getXMLObj(xmlStr)
	{
		var xml;
		if(jQuery.browser.msie){
			xml = new ActiveXObject("Microsoft.XMLDOM");
			xml.async = false;
			xml.loadXML(xmlStr);
		}else{
			xml = new DOMParser().parseFromString(xmlStr, "text/xml");
		}
		return xml;
	}
	
	/*
	* 生成tree格式的html
	* @param str:要生成html格式的字符串
	* @param tree: 要遍历的tree XMl对象
	* @parem isTop: 是否是顶级结点
	*/
	function treeChart(str,tree,isTop)
	{
		if(isTop){
			if(jQuery(tree).attr('name').length>12)
			{
				str +='<li><span style=\"font-size:12px;\" deptId=\"'+jQuery(tree).attr('id')+'\" isLoad=false >'
					+ jQuery(tree).attr('name')+"</span>";
			}
			else
			{
				str +='<li><span deptId=\"'+jQuery(tree).attr('id')+'\" >'
					+ jQuery(tree).attr('name')+"</span>";
			}
				
		}else{
			str +='<li><span deptId=\"'+jQuery(tree).attr('id')+'\" >'
				+ jQuery(tree).attr('name')+"</span>";
		}
		
		var childT = jQuery(tree).children("tree");	//获取子结点
		if(jQuery(childT).length>0)
		{
			str +='<ul>'
			jQuery(childT).each(function(){
				str = treeChart(str,jQuery(this));
			});
			
			str +='</ul>';
		}else{
			str +='</li>';
		}
		return str;
	}
	
</script>


<body>



<div id="chart"  class="orgChart"></div>

<@fkMacros.pageFooter />


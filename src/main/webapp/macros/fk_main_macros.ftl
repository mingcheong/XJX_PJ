<#-- 项目名称 -->
<#macro title>
<title>新江厦副食品批发管理系统</title>
</#macro>

<#-- JSP标签库 -->
<#macro taglibs>
<#global fn=JspTaglibs["/WEB-INF/tld/fn.tld"]><#global fck=JspTaglibs["/WEB-INF/tld/fckEditor.tld"]><#global c=JspTaglibs["/WEB-INF/tld/c.tld"]><#global fmt=JspTaglibs["/WEB-INF/tld/fmt.tld"]> <#global s=JspTaglibs["/WEB-INF/tld/struts-tags.tld"]><#global jmesa=JspTaglibs["/WEB-INF/tld/jmesa.tld"]>
</#macro>

<#-- 页面头文件 -->
<#macro pageHeader>
<@taglibs />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<head>
		<@title />
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
			<script>jQuery.noConflict();</script>
	</head><@loading /><body>
</#macro>

<#-- 页面头文件EasyUI -->
<#macro easyuiHeader script>
<@taglibs />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<@title />
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
			<script>
				jQuery.noConflict();
				$(function(){
					${script}();	
				
				});
				
			</script>
	</head><@loading /><body>
</#macro>

<#-- 页面加载动态提示 -->
<#macro loading>
<link rel="stylesheet" type="text/css" href="${resourcePath}/loading/style.css" /><script src="${resourcePath}/loading/loading.js"></script><div id="loading"><div class="loading-indicator">页面正在加载中...</div></div>
</#macro>

<#-- 单选用的树
参数说明：obj1 obj2 指的是树形中选中某个单选框时所要返回的id和名称,
		 datas 初始化树形时所要填充的json数据，在框架中已有对应的树形对象-->
<#macro radioTree obj1 obj2 url datas>
<link href="${resourcePath}/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" /><script src="${resourcePath}/ztree/js/jquery.ztree.all-3.1.min.js" type="text/javascript"></script><SCRIPT type="text/javascript">
var radioTreeSetting={async:{enable:true,url:radioTreeGetUrl},check:{enable:true,chkStyle:"radio",radioType:"all"},data:{simpleData:{enable:true}},view:{dblClickExpand:true},callback:{beforeExpand:radioTreeBeforeExpand,onAsyncSuccess:radioTreeOnAsyncSuccess,onAsyncError:radioTreeOnAsyncError,onCheck:radioTreeOnCheck}};function radioTreeGetUrl(treeId,treeNode){var url="${url}";var param="?id="+treeNode.id;return url+param;}var radioTreeNodes=${datas};function radioTreeBeforeExpand(treeId,treeNode){if(!treeNode.isAjaxing){radioTreeAjaxGetNodes(treeNode,"refresh");return true;}else{alert("正在下载数据中，请稍后展开节点。。。");return false;}}function radioTreeAjaxGetNodes(treeNode,reloadType){var zTree=jQuery.fn.zTree.getZTreeObj("radioTree");if(reloadType=="refresh"){treeNode.icon="${resourcePath}/ztree/img/loading.gif";zTree.updateNode(treeNode);}zTree.reAsyncChildNodes(treeNode,reloadType,true);}function radioTreeOnAsyncError(event,treeId,treeNode,XMLHttpRequest,textStatus,errorThrown){var zTree=jQuery.fn.zTree.getZTreeObj("radioTree");alert("异步获取数据出现异常。");treeNode.icon="";zTree.updateNode(treeNode);}function radioTreeOnAsyncSuccess(event,treeId,treeNode,msg){if(!msg||msg.length==0){return;}var zTree=jQuery.fn.zTree.getZTreeObj("radioTree"),totalCount=treeNode.count;if(treeNode.children.length<totalCount){setTimeout(function(){radioTreeAjaxGetNodes(treeNode);},perTime);}else{treeNode.icon="";zTree.updateNode(treeNode);zTree.selectNode(treeNode.children[0]);}}function radioTreeOnCheck(e,treeId,treeNode){var zTree=jQuery.fn.zTree.getZTreeObj("radioTree"),nodes=zTree.getCheckedNodes(true),v1="",v2="";for(var i=0,l=nodes.length;i<l;i++){v1+=nodes[i].id+",";v2+=nodes[i].name+",";}if(v1.length>0&&v2.length>0)v1=v1.substring(0,v1.length-1);v2=v2.substring(0,v2.length-1);jQuery("#${obj1}").attr("value",v1);jQuery("#${obj2}").attr("value",v2);}function radioTreeShowMenu(){var cityObj=jQuery("#${obj2}");var cityOffset=jQuery("#${obj2}").offset();jQuery("#radioTreeContent").css({left:cityOffset.left+"px",top:cityOffset.top+cityObj.outerHeight()+"px"}).slideDown("fast");jQuery("body").bind("mousedown",radioTreeOnBodyDown);}function radioTreeHideMenu(){jQuery("#radioTreeContent").fadeOut("fast");jQuery("body").unbind("mousedown",radioTreeOnBodyDown);}function radioTreeOnBodyDown(event){if(!(event.target.id=="menuBtn"||event.target.id=="${obj2}"||event.target.id=="radioTreeContent"||jQuery(event.target).parents("#radioTreeContent").length>0)){radioTreeHideMenu();}}jQuery(document).ready(function(){jQuery.fn.zTree.init(jQuery("#radioTree"),radioTreeSetting,radioTreeNodes);});
</SCRIPT>
<div id="radioTreeContent" class="menuContent"style="display:none; position: absolute;"><ul id="radioTree" class="ztree" style="margin-top:0; width:210px; height: 350px;"></ul></div><a href="#" onclick="radioTreeShowMenu(); return false;">选择</a>
</#macro>

<#--
带复选框的树型
参数说明：treeType 选择方式（yes:可上下关联，no:不关联）,
		 obj1 obj2 指的是树形中选中某个单选框时所要返回的id和名称,
		 url 异步加载所要请求的URL地址,
		 datas 初始化树形时所要填充的json数据，在框架中已有对应的树形对象-->
<#macro checkBoxTree treeType obj1 obj2 url datas>
<link href="${resourcePath}/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" /><script src="${resourcePath}/ztree/js/jquery.ztree.all-3.1.min.js" type="text/javascript"></script><SCRIPT type="text/javascript">
var checkBoxSetting={async:{enable:true,url:getCheckBoxUrl},check:{enable:true,<#if treeType?if_exists=="yes">chkboxType:{"Y":"ps","N":"ps"}<#else>chkboxType:{"Y":"","N":""}</#if>},data:{simpleData:{enable:true}},view:{dblClickExpand:true},callback:{beforeExpand:checkBoxBeforeExpand,onAsyncSuccess:checkBoxOnAsyncSuccess,onAsyncError:checkBoxOnAsyncError,onCheck:checkBoxOnCheck}};function getCheckBoxUrl(treeId,treeNode){var url="${url}";var param="?id="+treeNode.id;return url+param;}var checkBoxDatas=${datas};function checkBoxBeforeExpand(treeId,treeNode){if(!treeNode.isAjaxing){checkBoxAjaxGetNodes(treeNode,"refresh");return true;}else{alert("正在下载数据中，请稍后展开节点。。。");return false;}}function checkBoxAjaxGetNodes(treeNode,reloadType){var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree");if(reloadType=="refresh"){treeNode.icon="${resourcePath}/ztree/img/loading.gif";zTree.updateNode(treeNode);}zTree.reAsyncChildNodes(treeNode,reloadType,true);}function checkBoxOnAsyncError(event,treeId,treeNode,XMLHttpRequest,textStatus,errorThrown){var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree");alert("异步获取数据出现异常。");treeNode.icon="";zTree.updateNode(treeNode);}function checkBoxOnAsyncSuccess(event,treeId,treeNode,msg){if(!msg||msg.length==0){return;}var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree"),totalCount=treeNode.count;if(treeNode.children.length<totalCount){setTimeout(function(){checkBoxAjaxGetNodes(treeNode);},perTime);}else{treeNode.icon="";zTree.updateNode(treeNode);zTree.selectNode(treeNode.children[0]);}}function checkBoxOnCheck(e,treeId,treeNode){var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree"),nodes=zTree.getCheckedNodes(true),v1="",v2="";for(var i=0,l=nodes.length;i<l;i++){v1+=nodes[i].id+",";v2+=nodes[i].name+",";}if(v1.length>0&&v2.length>0)v1=v1.substring(0,v1.length-1);v2=v2.substring(0,v2.length-1);jQuery("#${obj1}").attr("value",v1);jQuery("#${obj2}").attr("value",v2);}function checkBoxShowMenu(){var cityObj=jQuery("#${obj2}");var cityOffset=jQuery("#${obj2}").offset();jQuery("#checkBoxContent").css({left:cityOffset.left+"px",top:cityOffset.top+cityObj.outerHeight()+"px"}).slideDown("fast");jQuery("body").bind("mousedown",checkBoxOnBodyDown);}function checkBoxHideMenu(){jQuery("#checkBoxContent").fadeOut("fast");jQuery("body").unbind("mousedown",checkBoxOnBodyDown);}function checkBoxOnBodyDown(event){if(!(event.target.id=="menuBtn"||event.target.id=="${obj2}"||event.target.id=="checkBoxContent"||jQuery(event.target).parents("#checkBoxContent").length>0)){checkBoxHideMenu();}}jQuery(document).ready(function(){jQuery.fn.zTree.init(jQuery("#checkboxTree"),checkBoxSetting,checkBoxDatas);});</script>
<div id="checkBoxContent" class="menuContent"style="display:none; position: absolute;"><ul id="checkboxTree" class="ztree" style="margin-top:0; width:210px; height: 350px;"></ul></div><a href="#" onclick="checkBoxShowMenu(); return false;">选择</a>
</#macro>


<#--
带复选框的树型
参数说明：treeType 选择方式（yes:可上下关联，no:不关联）,
		 url 异步加载所要请求的URL地址,
		 datas 初始化树形时所要填充的json数据，在框架中已有对应的树形对象-->
<#macro checkBoxTree2 obj datas url>
<link href="${resourcePath}/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" /><script src="${resourcePath}/ztree/js/jquery.ztree.all-3.1.min.js" type="text/javascript"></script><SCRIPT type="text/javascript">
var checkBoxSetting={async:{enable:true,url:getCheckBoxUrl},check:{enable:true,chkboxType:{"Y":"","N":""}},data:{simpleData:{enable:true}},view:{dblClickExpand:true},callback:{beforeExpand:checkBoxBeforeExpand,onAsyncSuccess:checkBoxOnAsyncSuccess,onAsyncError:checkBoxOnAsyncError,onCheck:checkBoxOnCheck}};function getCheckBoxUrl(treeId,treeNode){var url="${url}";var param="?id="+treeNode.id;return url+param}var checkBoxDatas=${datas};function checkBoxBeforeExpand(treeId,treeNode){if(!treeNode.isAjaxing){checkBoxAjaxGetNodes(treeNode,"refresh");return true}else{alert("正在下载数据中，请稍后展开节点。。。");return false}}function checkBoxAjaxGetNodes(treeNode,reloadType){var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree");if(reloadType=="refresh"){treeNode.icon="${resourcePath}/ztree/img/loading.gif";zTree.updateNode(treeNode)}zTree.reAsyncChildNodes(treeNode,reloadType,true)}function checkBoxOnAsyncError(event,treeId,treeNode,XMLHttpRequest,textStatus,errorThrown){var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree");alert("异步获取数据出现异常。");treeNode.icon="";zTree.updateNode(treeNode)}function checkBoxOnAsyncSuccess(event,treeId,treeNode,msg){if(!msg||msg.length==0){return}var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree"),totalCount=treeNode.count;if(treeNode.children.length<totalCount){setTimeout(function(){checkBoxAjaxGetNodes(treeNode)},perTime)}else{treeNode.icon="";zTree.updateNode(treeNode);zTree.selectNode(treeNode.children[0])}}function checkBoxOnCheck(e,treeId,treeNode){var zTree=jQuery.fn.zTree.getZTreeObj("checkboxTree"),nodes=zTree.getCheckedNodes(true),v1="";for(var i=0,l=nodes.length;i<l;i++){v1+=nodes[i].id+","}if(v1.length>0)v1=v1.substring(0,v1.length-1);var url=jQuery("#${obj}").attr("url");jQuery("#${obj}").attr("src",url+v1)}jQuery(document).ready(function(){jQuery.fn.zTree.init(jQuery("#checkboxTree"),checkBoxSetting,checkBoxDatas)});</script>
<ul id="checkboxTree" class="ztree" style="width:200px; overflow:auto;"></ul>
</#macro>
<#--
普通树形
参数说明：obj 指树的容器，如<ul id="ztree"></ul>,
		 url 异步加载所要请求的URL地址,
		 datas 初始化树形时所要填充的json数据，在框架中已有对应的树形对象-->
<#macro simpleTree obj datas url>
<link href="${resourcePath}/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" /><script src="${resourcePath}/ztree/js/jquery.ztree.all-3.1.min.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">var simpleTreeSetting={async:{enable:true,url:simpleTreeGetUrl},data:{simpleData:{enable:true}},view:{dblClickExpand:false},callback:{simpleTreeBeforeExpand:simpleTreeBeforeExpand,onAsyncSuccess:simpleTreeOnAsyncSuccess,onAsyncError:simpleTreeOnAsyncError,onClick:simpleTreeOnClick}};function simpleTreeGetUrl(treeId,treeNode){var url="${url}";var param="?id="+treeNode.id;return url+param}var simpleTreeNodes=${datas};function simpleTreeBeforeExpand(treeId,treeNode){if(!treeNode.isAjaxing){simpleTreeAjaxGetNodes(treeNode,"simpleTree");return true;}else{alert("正在下载数据中，请稍后展开节点。。。");return false;}}function simpleTreeAjaxGetNodes(treeNode,reloadType){var zTree=jQuery.fn.zTree.getZTreeObj("simpleTree");if(reloadType=="refresh"){treeNode.icon="${resourcePath}/ztree/img/loading.gif";zTree.updateNode(treeNode);}zTree.reAsyncChildNodes(treeNode,reloadType,true);}function simpleTreeOnAsyncError(event,treeId,treeNode,XMLHttpRequest,textStatus,errorThrown){var zTree=jQuery.fn.zTree.getZTreeObj("simpleTree");alert("异步获取数据出现异常。");treeNode.icon="";zTree.updateNode(treeNode);}function simpleTreeOnAsyncSuccess(event,treeId,treeNode,msg){if(!msg||msg.length==0){return;}var zTree=jQuery.fn.zTree.getZTreeObj("simpleTree"),totalCount=treeNode.count;if(treeNode.children.length<totalCount){setTimeout(function(){simpleTreeAjaxGetNodes(treeNode);},perTime);}else{treeNode.icon="";zTree.updateNode(treeNode);zTree.selectNode(treeNode.children[0]);}}function simpleTreeOnClick(e,treeId,treeNode){var zTree=jQuery.fn.zTree.getZTreeObj("simpleTree"),nodes=zTree.getSelectedNodes(),v1="";for(var i=0,l=nodes.length;i<l;i++){v1+=nodes[i].id+",";}if(v1.length>0)v1=v1.substring(0,v1.length-1);var url=jQuery("#${obj}").attr("url");jQuery("#${obj}").attr("src",url+v1);}jQuery(document).ready(function(){jQuery.fn.zTree.init(jQuery("#simpleTree"),simpleTreeSetting,simpleTreeNodes);});</script><ul id="simpleTree" class="ztree" style="width:200px; overflow:auto;"></ul>
</#macro>

<#-- 
页面验证
参数说明：formId 表单ID号
-->	
<#macro formValidator formId  validateType=6>
<link href="${resourcePath}/validator/css/validator.css" rel="stylesheet" type="text/css" /><script src="${resourcePath}/validator/js/mootools.js" type="text/javascript"></script><script src="${resourcePath}/validator/js/full-validator.js" type="text/javascript"></script><script language="javascript" type="text/javascript">var formValidator=Validator.setup({form : '${formId}',configs : 'attribute,tag',<#switch validateType><#case 1>warns : 'color,class,tips',<#break><#case 2>warns : 'color,alert',<#break><#case 3>warns : 'follow,color,class,tips',<#break><#case 4>warns : 'summary,color',summary : { id : 'summary'},<#break><#case 5>warns : 'summary,follow,color',summary : { id : 'summary'},<#break><#default>warns : 'follow,color,class',</#switch>color : {warn :'black', pass:'black'}});</script>
</#macro>

<#macro no_refresh>
<script>
document.onkeydown = function(){
　　if(event.keyCode==116) {event.keyCode=0;event.returnValue = false;}
}
document.oncontextmenu = function() {event.returnValue = false;}
</script>
</#macro>

<#-- 页尾 -->
<#macro pageFooter>
</body></html>
</#macro>
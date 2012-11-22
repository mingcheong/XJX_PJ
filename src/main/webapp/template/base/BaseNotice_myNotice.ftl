<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 -->
<@fkMacros.pageHeader />
<link href="${resourcePath}/wbox/css/wbox.css" rel="stylesheet" type="text/css" />
<script src="${resourcePath}/wbox/wbox.js" type="text/javascript"></script>
<@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：我的通知</div></td>
    </tr>
</table>
<@s.form id="baseNoticeForm" action="baseNotice_myNotice.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">标题</th>
		        <td>
		        	<@s.textfield id="name" name="baseNoticeModel.name" cssStyle="width:150px"/>
		        </td>
				<th width="15%">类型</th>
		        <td>
		        	<select name="baseNoticeModel.type" id="notice_type"></select>
		        </td>
				<th width="15%">发布时间</th>
		        <td>
		        	<@s.textfield id="releaseDate" name="baseNoticeModel.releaseDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"  cssStyle="width:150px"/>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('baseNoticeModel','filter');"/>
		        </td>
	     	</tr>
	    </table>
    </td>
  </tr>
  <tr>
    <td class="tool-toggle-td"><a id="J_SearchBoxToggle" state="show" hidefocus="true" href="javascript:;" title="收起/展开" onClick="toggleQueryPanel()" class="tool-toggle"></a></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<!--<ul>
			<@util.menu_add '添 加'> obj="baseNotice" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="baseNotice" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="baseNotice" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>-->
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=baseNoticeModels  limit=baseNoticeModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="baseNotice" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="baseNoticeModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="序号" filterable=false sortable=false>
					${rowcount+((baseNoticeModel.pageNo-1)*baseNoticeModel.pageSize)}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="name" title="标题" ><a href="baseNotice_showNotice.xhtml?id=${baseNotice.id}">${baseNotice.name}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="implUnit" title="实施单位" />
				<@jmesa.htmlColumn property="releaseDate" title="发布时间" />
				<@jmesa.htmlColumn property="type" title="类型" ><@enum.getSelectEnum code="${baseNotice.type}"/></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="fkUserModel.truename" title="填报人" />
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<@enum.initAllEnum />
<script type="text/javascript">
<#if baseNoticeModel.type?if_exists != "">jQuery("#notice_type").val("${baseNoticeModel.type}");</#if>
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('baseNotice_report.xhtml?' + parameterString);
    }
     var wbox = jQuery("#selectHerf").wBox({
	title:"通知详情！",
	requestType: "iframe", 
	iframeWH:{width:600,height:400},
	target:"baseNotice_showNotice.xhtml"
});
</script>

<@fkMacros.pageFooter />


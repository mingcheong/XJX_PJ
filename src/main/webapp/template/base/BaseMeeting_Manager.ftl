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
<@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：会议记录管理</div></td>
    </tr>
</table>
<@s.form id="baseMeetingForm" action="baseMeeting_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%" align="right">标题&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" >
		        	<@s.textfield id="name" name="baseMeetingModel.name"/>
		        </td>
		        <th width="15%"  align="right">类别&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" >
		        	<select name="baseMeetingModel.modelType" id="MeetingModelType"></select>
		        </td>
				<th width="15%"  align="right">类型&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" >
		        	<select name="baseMeetingModel.type" id="ReportType"></select>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('baseMeetingModel','filter');"/>
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
		<ul>
			<@util.menu_add '添 加'> obj="baseMeeting" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="baseMeeting" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="baseMeeting" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=baseMeetingModels  limit=baseMeetingModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="baseMeeting" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="baseMeetingModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${baseMeeting.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="name" title="标题" ><a href="${contextPath}/baseMeeting_detail.xhtml?id=${baseMeeting.id}">${baseMeeting.name}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="implUnit" title="实施单位" />
				<@jmesa.htmlColumn property="releaseDate" title="发布时间" />
				<@jmesa.htmlColumn property="modelType" title="类型" ><@enum.getSelectEnum code="${baseMeeting.modelType}"/></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="type" title="类型" ><@enum.getSelectEnum code="${baseMeeting.type}"/></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="fkUserModel.truename" title="填报人" />
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<script type="text/javascript">
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('baseMeeting_report.xhtml?' + parameterString);
    }
</script>
<@enum.initAllEnum /><script type="text/javascript"> <#if baseMeetingModel.type?if_exists != "">jQuery("#ReportType").val("${baseMeetingModel.type}");</#if> <#if baseMeetingModel.modelType?if_exists != "">jQuery("#MeetingModelType").val("${baseMeetingModel.modelType}");</#if></script>
<@fkMacros.pageFooter />


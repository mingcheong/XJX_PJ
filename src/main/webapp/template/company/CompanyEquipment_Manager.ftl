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
<@enum.initEnumXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：特种设备管理</div></td>
    </tr>
</table>
<@s.form id="companyEquipmentForm" action="companyEquipment_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">设备名称</th>
		        <td width="20%">
		        	<@s.textfield id="name" name="companyEquipmentModel.name" cssStyle="width:75%"/>
		        </td>
		        <th width="15%">设备类型</th>
		        <td width="20%">
		        	<select id="equipentType" name="companyEquipmentModel.equipentType" cssStyle="width:75%"/>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyEquipmentModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="companyEquipment" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="companyEquipment" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="companyEquipment" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyEquipmentModels  limit=companyEquipmentModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyEquipment" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyEquipmentModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyEquipment.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="name" title="设备名称" />
				<@jmesa.htmlColumn property="safetyPerson" title="安全管理人员" />
				<@jmesa.htmlColumn property="state" title="设备状态">
					<@enum.getSelectEnum companyEquipment.state/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="equipentType" title="设备类型" >
					<@enum.getSelectEnum companyEquipment.equipentType/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="usedUnit" title="单位名称" />

		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>

<@enum.initAllEnum />
<script type="text/javascript">

	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyEquipment_report.xhtml?' + parameterString);
    }
    <#if companyEquipmentModel.equipentType?if_exists != "">
		jQuery("#equipentType").val("${companyEquipmentModel.equipentType}");
	</#if> 
</script>
<@fkMacros.pageFooter />


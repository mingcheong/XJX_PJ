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
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：菜单资源管理</div></td>
    </tr>
</table>
<@s.form id="fkResourceForm" action="fkResource_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">菜单名称:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="resourceName" name="fkResourceModel.resourceName" cssStyle="width:65%"/>
					<ui:v for="resourceName" rule="require" warn="不允许以空格为开始" empty="菜单名称不允许为空" pass="&nbsp;"/>
				</td>
				<th width="15%">创建时间:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="createDate" name="fkResourceModel.createDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:65%"/>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('fkResourceModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="fkResource" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="fkResource" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="fkResource" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=fkResourceModels  limit=fkResourceModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="fkResource" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="fkResourceModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${fkResource.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn width="25%" property="resourceName" title="资源名称" />
				<@jmesa.htmlColumn width="45%" property="resourceUrl" title="访问地址" />
				<@jmesa.htmlColumn width="25%" property="createDate" title="创建时间" />
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
        window.open('fkResource_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


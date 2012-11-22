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
<@s.form id="fkAreaForm" action="fkArea_manager.xhtml"><@s.token /><@s.hidden id="id" name="fkAreaModel.fatherId" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_add '添 加'> obj="fkArea" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="fkArea" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="fkArea" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=fkAreaModels  limit=fkAreaModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="fkArea" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="fkAreaModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${fkArea.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn width="15%" property="areaCode" title="区域代码" />
				<@jmesa.htmlColumn width="25%" property="areaName" title="区域名称" />
				<@jmesa.htmlColumn width="45%" property="createDate" title="创建时间" />
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
        window.open('fkArea_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


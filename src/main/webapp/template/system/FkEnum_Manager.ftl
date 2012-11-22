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
<@s.form id="fkEnumForm" action="fkEnum_manager.xhtml"><@s.token /><@s.hidden id="id" name="fkEnumModel.fatherId"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_add '添 加'> obj="fkEnum" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="fkEnum" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="fkEnum" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=fkEnumModels  limit=fkEnumModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="fkEnum" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="fkEnumModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${fkEnum.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn width="15%" property="enumCode" title="枚举代码" />
				<@jmesa.htmlColumn width="25%" property="enumName" title="枚举名称" />
				<@jmesa.htmlColumn width="45%" property="enumDesc" title="枚举描述" />
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
        window.open('fkEnum_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


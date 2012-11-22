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
    	<td align="center" ><div class="dqwz">您现在的位置：jxInInventory管理</div></td>
    </tr>
</table>
<@s.form id="jxInInventoryForm" action="jxInInventory_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">请放置查询对象</th>
		        <td>
		        	<input name="demo" type="text" size="25" id="demo" value="这是一个演示字段" maxlength="20">
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('jxInInventoryModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="jxInInventory" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="jxInInventory" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="jxInInventory" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=jxInInventoryModels  limit=jxInInventoryModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="jxInInventory" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="jxInInventoryModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${jxInInventory.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="jiCode" title="jiCode" />
				<@jmesa.htmlColumn property="jiLastCode" title="jiLastCode" />
				<@jmesa.htmlColumn property="jiOcode" title="jiOcode" />
				<@jmesa.htmlColumn property="jiCodemark" title="jiCodemark" />
				<@jmesa.htmlColumn property="jiDept" title="jiDept" />
				<@jmesa.htmlColumn property="jiSupplier" title="jiSupplier" />
				<@jmesa.htmlColumn property="jiUser" title="jiUser" />
				<@jmesa.htmlColumn property="jiDate" title="jiDate" />
				<@jmesa.htmlColumn property="jiCheckuser" title="jiCheckuser" />
				<@jmesa.htmlColumn property="jiWarehouse" title="jiWarehouse" />
				<@jmesa.htmlColumn property="jiRemark" title="jiRemark" />
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
        window.open('jxInInventory_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


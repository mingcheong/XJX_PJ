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
    	<td align="center" ><div class="dqwz">您现在的位置：jxBackInventoryDetails管理</div></td>
    </tr>
</table>
<@s.form id="jxBackInventoryDetailsForm" action="jxBackInventoryDetails_manager.xhtml"><@s.token />
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
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('jxBackInventoryDetailsModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="jxBackInventoryDetails" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="jxBackInventoryDetails" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="jxBackInventoryDetails" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=jxBackInventoryDetailsModels  limit=jxBackInventoryDetailsModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="jxBackInventoryDetails" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="jxBackInventoryDetailsModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${jxBackInventoryDetails.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="jbdBackInventory" title="jbdBackInventory" />
				<@jmesa.htmlColumn property="jbdBarcode" title="jbdBarcode" />
				<@jmesa.htmlColumn property="jbdCode" title="jbdCode" />
				<@jmesa.htmlColumn property="jbdName" title="jbdName" />
				<@jmesa.htmlColumn property="jbdUnit" title="jbdUnit" />
				<@jmesa.htmlColumn property="jbdQuantity" title="jbdQuantity" />
				<@jmesa.htmlColumn property="jbdCost" title="jbdCost" />
				<@jmesa.htmlColumn property="jbdAmount" title="jbdAmount" />
				<@jmesa.htmlColumn property="jbdNum" title="jbdNum" />
				<@jmesa.htmlColumn property="jbdOverflow" title="jbdOverflow" />
				<@jmesa.htmlColumn property="jbdRate" title="jbdRate" />
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
        window.open('jxBackInventoryDetails_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


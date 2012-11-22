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
    	<td align="center" ><div class="dqwz">您现在的位置：jxSalesDetails管理</div></td>
    </tr>
</table>
<@s.form id="jxSalesDetailsForm" action="jxSalesDetails_manager.xhtml"><@s.token />
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
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('jxSalesDetailsModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="jxSalesDetails" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="jxSalesDetails" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="jxSalesDetails" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=jxSalesDetailsModels  limit=jxSalesDetailsModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="jxSalesDetails" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="jxSalesDetailsModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${jxSalesDetails.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="jsdSales" title="jsdSales" />
				<@jmesa.htmlColumn property="jsdBarcode" title="jsdBarcode" />
				<@jmesa.htmlColumn property="jsdCode" title="jsdCode" />
				<@jmesa.htmlColumn property="jsdName" title="jsdName" />
				<@jmesa.htmlColumn property="jsdUnit" title="jsdUnit" />
				<@jmesa.htmlColumn property="jsdQuantity" title="jsdQuantity" />
				<@jmesa.htmlColumn property="jsdCost" title="jsdCost" />
				<@jmesa.htmlColumn property="jsdAmount" title="jsdAmount" />
				<@jmesa.htmlColumn property="jsdNum" title="jsdNum" />
				<@jmesa.htmlColumn property="jsdOverflow" title="jsdOverflow" />
				<@jmesa.htmlColumn property="jsdRate" title="jsdRate" />
				<@jmesa.htmlColumn property="jsdPag" title="jsdPag" />
				<@jmesa.htmlColumn property="jsdWcost" title="jsdWcost" />
				<@jmesa.htmlColumn property="jsdWamount" title="jsdWamount" />
				<@jmesa.htmlColumn property="jsdPre" title="jsdPre" />
				<@jmesa.htmlColumn property="jsdSamount" title="jsdSamount" />
				<@jmesa.htmlColumn property="jsdCustitem" title="jsdCustitem" />
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
        window.open('jxSalesDetails_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


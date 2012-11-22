<#include "/macro.include"/>
<#include "/page_copyright.include">
<#assign className = table.className>   
<#assign contentPath = table.contentName> 
<#assign classNameLower = className?uncap_first>
${"<@fkMacros.pageHeader />"}
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：${classNameLower}管理</div></td>
    </tr>
</table>
${"<@s.form"} id="${classNameLower}Form" action="${classNameLower}_manager.xhtml">${"<@s.token />"}
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
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('${classNameLower}Model','filter');"/>
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
			${"<@util.menu_add '添 加'>"} obj="${classNameLower}" ${"</@util.menu_add>"}
			${"<@util.menu_edit '编 辑'>"} obj="${classNameLower}" ${"</@util.menu_edit>"}
			${"<@util.menu_delAll '删 除'>"} obj="${classNameLower}" ${"</@util.menu_delAll>"}
			${"<@util.menu_reload '刷 新'/>"}
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
${"<@jmesa.tableModel"} items=${classNameLower}Models  limit=${classNameLower}Model.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="${classNameLower}" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="${classNameLower}Model" exportTypes="pdf,excel,csv">
	${"<@jmesa.htmlTable"} width="100%" style="text-align:left;">
		${"<@jmesa.htmlRow>"}
			<@generateColumnProperties />
		${"</@jmesa.htmlRow>"}
	${"</@jmesa.htmlTable>"}
${"</@jmesa.tableModel>"}
${"</@s.form>"}
<script type="text/javascript">
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('${classNameLower}_report.xhtml?' + parameterString);
    }
</script>
${"<@fkMacros.pageFooter />"}

<#macro generateColumnProperties>
	<#list table.columns as column>
		<#if !column.pk >
			<#if !column.pk && column.columnNameLower != "isDeleted" && column.columnNameLower != "sortNum" && column.columnNameLower != "createDate" && column.columnNameLower != "modifyDate" 
				&& column.columnNameLower != "firstarea" && column.columnNameLower != "secondarea" && column.columnNameLower != "thirdarea" && column.columnNameLower != "fourtharea" && column.columnNameLower != "fiftharea">
				${"<@jmesa.htmlColumn"} property="${column.columnNameLower}" title="${column.columnNameLower}" />
			</#if>
		<#else>
				${"<@jmesa.htmlColumn"} property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="<@jspEl '${classNameLower}.id' />" />
				${"</@jmesa.htmlColumn>"}
		</#if>
	</#list>
</#macro>
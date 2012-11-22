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
    	<td align="center" ><div class="dqwz">您现在的位置：companyReports管理</div></td>
    </tr>
</table>
<@s.form id="companyReportsForm" action="companyReports_manager.xhtml"><@s.token />
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
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyReportsModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="companyReports" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="companyReports" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="companyReports" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyReportsModels  limit=companyReportsModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyReports" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyReportsModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyReports.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="industryType" title="industryType" />
				<@jmesa.htmlColumn property="startMonth" title="startMonth" />
				<@jmesa.htmlColumn property="startYear" title="startYear" />
				<@jmesa.htmlColumn property="unitResponsible" title="unitResponsible" />
				<@jmesa.htmlColumn property="fillPerson" title="fillPerson" />
				<@jmesa.htmlColumn property="contactPhone" title="contactPhone" />
				<@jmesa.htmlColumn property="fillDate" title="fillDate" />
				<@jmesa.htmlColumn property="n1" title="n1" />
				<@jmesa.htmlColumn property="n2" title="n2" />
				<@jmesa.htmlColumn property="n3" title="n3" />
				<@jmesa.htmlColumn property="n4" title="n4" />
				<@jmesa.htmlColumn property="n5" title="n5" />
				<@jmesa.htmlColumn property="n6" title="n6" />
				<@jmesa.htmlColumn property="n7" title="n7" />
				<@jmesa.htmlColumn property="n8" title="n8" />
				<@jmesa.htmlColumn property="n9" title="n9" />
				<@jmesa.htmlColumn property="n10" title="n10" />
				<@jmesa.htmlColumn property="n11" title="n11" />
				<@jmesa.htmlColumn property="n12" title="n12" />
				<@jmesa.htmlColumn property="n13" title="n13" />
				<@jmesa.htmlColumn property="n14" title="n14" />
				<@jmesa.htmlColumn property="n15" title="n15" />
				<@jmesa.htmlColumn property="n16" title="n16" />
				<@jmesa.htmlColumn property="n17" title="n17" />
				<@jmesa.htmlColumn property="n18" title="n18" />
				<@jmesa.htmlColumn property="n19" title="n19" />
				<@jmesa.htmlColumn property="n20" title="n20" />
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
        window.open('companyReports_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


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
    	<td align="center" ><div class="dqwz">您现在的位置：工作计划列表</div></td>
    </tr>
</table>
<@s.form id="baseWorkplanForm" action="baseWorkplan_list.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%" align="right">标题&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        <@s.textfield id="name" name="baseWorkplanModel.name" />
		        </td>
				<th width="15%" align="right">类别&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<select name="baseWorkplanModel.modelType" id="WorkplanModelType"></select>
		        </td>
				<th width="15%" align="right">类型&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<select name="baseWorkplanModel.type" id="ReportType"></select>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('baseWorkplanModel','filter');"/>
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
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=baseWorkplanModels  limit=baseWorkplanModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="baseWorkplan" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="baseWorkplanModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="序号" filterable=false sortable=false>
					${rowcount+((baseWorkplanModel.pageNo-1)*baseWorkplanModel.pageSize)}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="name" title="标题" ><a href="${contextPath}/baseWorkplan_detail.xhtml?id=${baseWorkplan.id}">${baseWorkplan.name}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="implUnit" title="实施单位" />
				<@jmesa.htmlColumn property="releaseDate" title="发布时间" />
				<@jmesa.htmlColumn property="modelType" title="类别" ><@enum.getSelectEnum code="${baseWorkplan.modelType}"/></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="type" title="上报类型" ><@enum.getSelectEnum code="${baseWorkplan.type}"/></@jmesa.htmlColumn>
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
        window.open('baseWorkplan_report.xhtml?' + parameterString);
    }
</script>
<@enum.initAllEnum /><script type="text/javascript"> <#if baseWorkplanModel.type?if_exists != "">jQuery("#ReportType").val("${baseWorkplanModel.type}");</#if><#if baseWorkplanModel.modelType?if_exists != "">jQuery("#WorkplanModelType").val("${baseWorkplanModel.modelType}");</#if> </script>
<@fkMacros.pageFooter />


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
    	<td align="center" ><div class="dqwz">您现在的位置：<#if companyHiddendangerModel?if_exists.companyInfoModel?if_exists.companyName?if_exists != "">${companyHiddendangerModel.companyInfoModel.companyName}的</#if>企业隐患列表</div></td>
    </tr>
</table>
<@s.form id="companyHiddendangerForm" action="companyHiddendanger_companyHidden.xhtml?id=${companyInfoModel.id}"><@s.token />
<@s.hidden name="companyInfoModel.id" id="param" />
<!--<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
		<tr>
				<th width="15%">隐患地址</th>
		        <td>
		        	<@s.textfield id="dangerAddress" name="companyHiddendangerModel.dangerAddress" cssStyle="width:75%"/>
		        </td>
				<th width="15%">单位区域</th>
		        <td>
		        	<div id="div-area"></div>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyHiddendangerModel','filter');"/>
		        </td>
	     	</tr>
	    </table>
    </td>
  </tr>
  <tr>
    <td class="tool-toggle-td"><a id="J_SearchBoxToggle" state="show" hidefocus="true" href="javascript:;" title="收起/展开" onClick="toggleQueryPanel()" class="tool-toggle"></a></td>
  </tr>
</table>-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.param_add '添 加'> obj="companyHiddendanger_insert.xhtml" </@util.param_add>
			<@util.param_edit '编 辑'> obj="companyHiddendanger_hiddenModify.xhtml" </@util.param_edit>
			<@util.param_del '删 除'> obj="companyHiddendanger_delHidden.xhtml" </@util.param_del>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyHiddendangerModels limit=companyHiddendangerModel.limit  filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyHiddendanger" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyHiddendangerModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyHiddendanger.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyInfoModel.companyName" title="单位名称" ><a href="${contextPath}/companyHiddendanger_detail.xhtml?id=${companyHiddendanger.id}">${companyHiddendanger.companyInfoModel.companyName}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="code" title="隐患编号" />
				<@jmesa.htmlColumn property="dangerAddress" title="隐患地址" />
				<@jmesa.htmlColumn property="dangerContact" title="联系人" />
				<@jmesa.htmlColumn property="dangerPhone" title="联系电话" />
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<@enum.initAllEnum /><script type="text/javascript"> <#if companyHiddendangerModel.level?if_exists != "">jQuery("#ReportType").val("${companyHiddendangerModel.level}");</#if></script>
<script type="text/javascript">
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyHiddendanger_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


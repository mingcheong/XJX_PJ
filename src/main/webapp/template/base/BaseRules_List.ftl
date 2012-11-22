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
    	<td align="center" ><div class="dqwz">您现在的位置：法律法规</div></td>
    </tr>
</table>
<@s.form id="baseRulesForm" action="baseRules_list.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">标题</th>
		        <td>
		        	<@s.textfield id="name" name="baseRulesModel.title" cssStyle="width:200px"/>
		        </td>
				<th width="15%">类型</th>
		        <td>
		        <select name="baseRulesModel.rulesType" id="rules_type"></select>
		        </td>
		        <th width="15%">发布时间</th>
		        <td>
		        	<@s.textfield id="releaseDate" name="baseRulesModel.releaseDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"   cssStyle="width:150px"/>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('baseRulesModel','filter');"/>
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
<@jmesa.tableModel items=baseRulesModels  limit=baseRulesModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="baseRules" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="baseRulesModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="序号" filterable=false sortable=false>
					${rowcount+((baseRulesModel.pageNo-1)*baseRulesModel.pageSize)}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="title" title="标题" ><a href="${contextPath}/baseRules_detail.xhtml?id=${baseRules.id}">${baseRules.title}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="rulesType" title="类型" ><@enum.getSelectEnum code="${baseRules.rulesType}"/></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="releaseDate" title="发布时间" />
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<@enum.initAllEnum /><script type="text/javascript">
<#if baseRulesModel.rulesType?if_exists != "">jQuery("#rules_type").val("${baseRulesModel.rulesType}");</#if>
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('baseRules_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


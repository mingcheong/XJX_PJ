<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 ManagerList
 -->
<@fkMacros.pageHeader />
<@enum.initEnumXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" >
    		<div class="dqwz">
    			您现在的位置：<#if companyInfoModel?if_exists != "">${companyInfoModel.companyName} 的</#if>标准化管理列表
    		</div>
    	</td>
    </tr>
</table>
<@s.form id="companyStandardForm" action="companyStandard_managerList.xhtml?id=${companyInfoModel.id}"><@s.token />
<input type="hidden" id="companyId" name="companyAccident.accidentUnit.id" value="${companyInfoModel.id}"/>
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				
		        <th width="12%"  align="right">标准化类型&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <select id="standardType" name="companyStandardModel.standardType" />
		        </td>
		        <th width="10%"  align="right">发证机关&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="issueUnit" name="companyStandardModel.issueUnit" />
		        </td>
		        <th width="10%"  align="right">证书编号&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="certificateNumber" name="companyStandardModel.certificateNumber" />
		        </td>
		        <td rowspan="2" width="8%">
		        	&nbsp;
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyStandardModel','filter');"/>
		        </td>
	     	</tr>

			<tr>
				<th width="10%"  align="right">达标级别&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <select id="companyLeavel" name="companyStandardModel.companyLeavel" />
		        </td>
				<th width="10%" align="right">有效日期&nbsp;&nbsp;&nbsp;</th>
				<td width="25%" colspan="3">
					<@s.textfield id="validityBegin" name="companyStandardModel.validityBegin" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
					至
					<@s.textfield id="validityEnd" name="companyStandardModel.validityEnd" readOnly="true"  onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',errDealMode:1})"/>
				</td >
		        
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
			<@util.company_addStand '添加标准化'> obj="companyStandard_insert.xhtml"</@util.company_addStand>
			<@util.menu_edit '编 辑标准化'> obj="companyStandard" </@util.menu_edit>
			<@util.company_delAll '删 除'> obj="companyStandard_remove.xhtml" </@util.company_delAll>
			<@util.menu_reload '刷 新'/>
			
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyStandardModels  limit=companyStandardModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyStandard" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyStandardModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyStandard.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyStandard.companyInfo.companyName" title="单位名称" >
					${companyStandard.companyInfo.companyName}
				</@jmesa.htmlColumn>

				<@jmesa.htmlColumn property="certificateNumber" title="证书编号" />
				<@jmesa.htmlColumn property="companyLeavel" title="达标级别" >
					<@enum.getSelectEnum companyStandard.companyLeavel/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="standardType" title="标准化类型" >
					<@enum.getSelectEnum companyStandard.standardType/>
				</@jmesa.htmlColumn>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>

</@s.form>
<@enum.initAllEnum />

<script type="text/javascript">
	if(get("standardType")){enumObj.initSelect("standardType","standardType");}
	<#if companyStandardModel.standardType?if_exists != "">jQuery("#standardType").val("${companyStandardModel.standardType}");</#if>
	if(get("companyLeavel")){enumObj.initSelect("companyLeavel","companyLeavel");}
	<#if companyStandardModel.companyLeavel?if_exists != "">jQuery("#companyLeavel").val("${companyStandardModel.companyLeavel}");</#if>
	
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyStandard_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


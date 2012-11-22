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
<@enum.initAreaXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz"><#if companyInfoModel?if_exists != "">${companyInfoModel.companyName}的</#if>事故管理列表</div></td>
    </tr>
</table>
<@s.form id="companyAccidentForm" action="companyAccident_managerList.xhtml?id=${companyInfoModel.id}"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
		        <th width="15%" align="right">事故大类&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <input type="hidden" id="companyId" name="companyAccident.accidentUnit.id" value="${companyInfoModel.id}"/>
		           <select id="bigtype" name="companyAccidentModel.bigtype" />
		        </td>
				<th width="10%" align="right">所在区域&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" colspan="3">
		        	<div id="div-area"></div>
		        </td>
		        <td width="15" rowspan="2">
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyAccidentModel','filter');"/>
		        </td>
	     	</tr>
	     	<tr>
	     		<th width="15%" align="right">事故报告单位名称&nbsp;&nbsp;&nbsp;</th>
				<td width="15%">
					<@s.textfield id="orgName" name="companyAccidentModel.accidentReportOrgan.orgName" />
				</td>
		     	<th width="10%" align="right">事故时间&nbsp;&nbsp;&nbsp;</th>
				<td width="15%">
					<@s.textfield id="validityBegin" name="companyAccidentModel.accidentDate" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
				</td>
				<th width="10%" align="right">是否已上报&nbsp;&nbsp;&nbsp;</th>
				<td width="15%">
					<select id="isReport" name="companyAccidentModel.isReport" />
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
			<@util.company_addStand '添加'> obj="companyAccident_insert.xhtml"</@util.company_addStand>
			<@util.menu_edit '编 辑'> obj="companyAccident" </@util.menu_edit>
			<@util.company_delAll '删 除'> obj="companyAccident_remove.xhtml" </@util.company_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyAccidentModels  limit=companyAccidentModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyAccident" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyAccidentModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyAccident.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="bigtype" title="事故大类">
					<@enum.getSelectEnum companyAccident.bigtype/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="accidentContact" title="事故所在区域">
					<@enum.getSelectArea '${companyAccident.firstArea}'/>
					&nbsp;
					<@enum.getSelectArea '${companyAccident.secondArea}'/>
					&nbsp;
					<@enum.getSelectArea '${companyAccident.thirdArea}'/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="accidentUnit" title="单位名称" >
					${companyAccident.accidentUnit.companyName}
				</@jmesa.htmlColumn >
				<@jmesa.htmlColumn property="accidentReportOrgan" title="事故报告单位名称">
					${companyAccident.accidentReportOrgan.orgName}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="accidentDate" title="事故时间" />
				<@jmesa.htmlColumn property="isReport" title="是否已上报" >
					<#if companyAccident.isReport?if_exists == true>
						已上报
					<#else>
						未上报
					</#if>
				</@jmesa.htmlColumn>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>

</@s.form>


<@enum.selectAreas "companyAccidentModel","div-area","${companyAccidentModel.firstArea?if_exists}","${companyAccidentModel.secondArea?if_exists}","${companyAccidentModel.thirdArea?if_exists}","${companyAccidentModel.fouthArea?if_exists}","${companyAccidentModel.fifthArea?if_exists}" />

<script type="text/javascript">
	
	if(get("bigtype")){enumObj.initSelect("accidentBigType","bigtype");}
	<#if companyAccidentModel.bigtype?if_exists !="" > jQuery("#bigtype").val("${companyAccidentModel.bigtype}");</#if>
	if(get("isReport")){
		var strR="<option value=''>--请选择--</option><option value='false'>否</option><option value='true'>是</option>";
		jQuery("#isReport").append(strR);
	}
	<#if companyAccidentModel.isReport?if_exists == true>
		jQuery("#isReport").val("true");
	<#elseif  companyAccidentModel.isReport?if_exists == "">
		jQuery("#isReport").val("");
	<#elseif companyAccidentModel.isReport?if_exists == false>
		jQuery("#isReport").val("false");
	</#if>
	
	
	function onInvokeAction(id) {
		if(jQuery("#isReport").val()=="")
		{
			jQuery("#isReport").remove();
		}
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyAccident_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


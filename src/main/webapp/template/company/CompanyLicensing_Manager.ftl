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
<style>
a {
  COLOR: #0066FF; FONT-SIZE: 12px
}
a:link {
	COLOR: #333; TEXT-DECORATION: none
}
a:visited {
	COLOR: #333; TEXT-DECORATION: none
}
a:hover {
	COLOR: #f00; TEXT-DECORATION: none
}
a:active {
	COLOR: #333; TEXT-DECORATION: none
}

</style>
	
<@enum.initEnumXML/>
<@enum.initAreaXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：行政许可列表</div></td>
    </tr>
</table>
<@s.form id="companyLicensingForm" action="companyLicensing_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="10%" align="right">单位名称&nbsp;&nbsp;&nbsp;</th>
		        <td width="20%">
		        	<@s.textfield id="companyName" name="companyLicensingModel.companyInfo.companyName" />
		        </td>
		        <th width="12%" align="right">许可证类型&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<select id="standardType" name="companyLicensingModel.standardType" />
		        </td>
		        <th width="12%" align="right">发证机关&nbsp;&nbsp;&nbsp;</th>
		        <td width="20%">
		        	<@s.textfield id="issueUnit" name="companyLicensingModel.issueUnit" />
		        </td>
		        
				<td rowspan="2">
					&nbsp;
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyLicensingModel','filter');"/>
		        </td>
	     	</tr>
	     	<tr>
	     		<th  align="right">证书编号&nbsp;&nbsp;&nbsp;</th>
		        <td >
		        	<@s.textfield id="certificateNumber" name="companyLicensingModel.certificateNumber" />
		        </td>
		     	<th align="right">有效日期&nbsp;&nbsp;&nbsp;</th>
				<td colspan="3">
					<@s.textfield id="validityBegin" name="companyLicensingModel.validityBegin" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
					至
					<@s.textfield id="validityEnd" name="companyLicensingModel.validityEnd" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',errDealMode:1})"/>
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
			<!--<@util.menu_add '添 加'> obj="companyLicensing" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="companyLicensing" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="companyLicensing" </@util.menu_delAll>-->
			<@util.menu_reload '刷 新'/>

		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>

<@jmesa.tableModel items=companyLicensingModels  limit=companyLicensingModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyLicensing" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyLicensingModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyLicensing.id}" />
				</@jmesa.htmlColumn>
				
				<@jmesa.htmlColumn property="certificateNumber" title="证书编号">
					<a href="companyLicensing_detail.xhtml?id=${companyLicensing.id}" title="点击查看详细信息!">${companyLicensing.certificateNumber}</a>
				</@jmesa.htmlColumn>
				
				<@jmesa.htmlColumn property="companyLicensing.companyInfo.companyName" title="单位名称" >
					${companyLicensing.companyInfo.companyName}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyLicensing.companyInfo.address" title="单位地址" >
					${companyLicensing.companyInfo.address}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="area" title="单位所在区域" >
					<@enum.getSelectArea '${companyLicensing.companyInfo.firstArea}'/>
					&nbsp;
					<@enum.getSelectArea '${companyLicensing.companyInfo.secondArea}'/>
					&nbsp;
					<@enum.getSelectArea '${companyLicensing.companyInfo.thirdArea}'/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyChief" title="主要负责人" />
				
				<@jmesa.htmlColumn property="standardType" title="证书类型" >
					<@enum.getSelectEnum companyLicensing.standardType/>
				</@jmesa.htmlColumn>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>

</@s.form>


<@enum.initAllEnum />
	
<script type="text/javascript">
	if(get("standardType")){enumObj.initSelect("licensingType","standardType");}
	<#if companyLicensingModel.standardType?if_exists != "">jQuery("#standardType").val("${companyLicensingModel.standardType}");</#if>

	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyLicensing_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


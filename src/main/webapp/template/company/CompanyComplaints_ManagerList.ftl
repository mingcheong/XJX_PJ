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
    	<td align="center" ><div class="dqwz">您现在的位置：举报投诉管理列表</div></td>
    </tr>
</table>
<@s.form id="companyComplaintsForm" action="companyComplaints_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="8%" align="right">举报人:&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="complaintsName" name="companyComplaintsModel.complaintsName" />
		        </td>
		        <th width="8%" align="right"> 文号:&nbsp;&nbsp;</th>
				<td width="15%">
					<@s.textfield id="paperNumber" name="companyComplaintsModel.paperNumber"  />
				</td>
		        <th width="8%" align="right"> 来电日期:&nbsp;&nbsp;</th>
				<td width="15%">
					<@s.textfield id="callsDate" name="companyComplaintsModel.callsDate" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
				</td>
				<th width="8%" align="right">登记人:&nbsp;&nbsp;</th>
		        <td width="15%" rowspan="2">
		        	<@s.textfield id="callsName" name="companyComplaintsModel.callsName" />
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyComplaintsModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="companyComplaints" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="companyComplaints" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="companyComplaints" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyComplaintsModels  limit=companyComplaintsModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyComplaints" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyComplaintsModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyComplaints.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="paperNumber" title="文号">
					<a href="companyComplaints_detail.xhtml?id=${companyComplaints.id}" title="点击查看详细信息!">${companyComplaints.paperNumber}</a>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="leaderName" title="领导姓名" />
				<@jmesa.htmlColumn property="complaintsName" title="举报人" />
				<@jmesa.htmlColumn property="callsName" title="受理人" />
				<@jmesa.htmlColumn property="isAppropriate" title="是否办妥" >
					<#if companyComplaints.isAppropriate == true>
						是
					<#else>
						否
					</#if>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="callsDate" title="来电日期" />
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
        window.open('companyComplaints_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


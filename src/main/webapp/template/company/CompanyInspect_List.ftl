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
    	<td align="center" ><div class="dqwz">您现在的位置：行政执法查询</div></td>
    </tr>
</table>
<@s.form id="companyInspectForm" action="companyInspect_list.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">检查单位</th>
		        <td>
		        	<@s.textfield id="enforceunit" name="companyInspectModel.enforceunit" cssStyle="width:160px;"/>
		        </td>
				<th width="15%">检查人员</th>
		        <td>
		        	<@s.textfield id="inspectors" name="companyInspectModel.inspectors" cssStyle="width:160px;"/>
		        </td>
				<th width="15%">记录人员</th>
		        <td>
		        	<@s.textfield id="recordors" name="companyInspectModel.recordors" cssStyle="width:160px;"/>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyInspectModel','filter');"/>
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
<@jmesa.tableModel items=companyInspectModels  limit=companyInspectModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyInspect" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyInspectModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
		<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="序号" filterable=false sortable=false>
					${rowcount+((companyInspect.pageNo-1)*companyInspect.pageSize)}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="1" title="被检查企业" >${companyInspect?if_exists.companyInfoModel?if_exists.companyName?default('')}</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="enforceunit" title="检查单位" />
				<@jmesa.htmlColumn property="place" title="检查场所" />
				<@jmesa.htmlColumn property="inspectors" title="检查人员" />
				<@jmesa.htmlColumn property="recordors" title="记录人员" />
				<@jmesa.htmlColumn property="startdate" title="检查时间" />
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
        window.open('companyInspect_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />


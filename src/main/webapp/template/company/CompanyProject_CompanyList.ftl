
<@fkMacros.pageHeader />
<@enum.initEnumXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：建设项目->企业列表</div></td>
    </tr>
</table>
<@s.form id="companyInfoForm" action="companyProject_companyList.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="10%">企业名称&nbsp;&nbsp;</th>
				<td width="20%" >
					<@s.textfield id="companyName" name="companyInfoModel.companyName" cssStyle="width:75%"/>
				</td>
				<th width="10%">企业地址&nbsp;&nbsp;</th>
				<td width="20%" >
					<@s.textfield id="address" name="companyInfoModel.address" cssStyle="width:75%"/>
				</td>
				<th width="10%">联系电话&nbsp;&nbsp;</th>
				<td width="20%" >
					<@s.textfield id="legalContact" name="companyInfoModel.legalContact" cssStyle="width:75%"/>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyInfoModel','filter');"/>
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
			<@util.company_add '添加建设项目'> obj="companyProject_managerList.xhtml"  </@util.company_add>
			<!--<@util.company_edit '编辑许可证'> obj="companyTrian_managerList.xhtml" </@util.company_edit>-->

			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyInfoModels  limit=companyInfoModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyInfo" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyInfoModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyInfo.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyName" title="企业名称" />
				<@jmesa.htmlColumn property="address" title="地址" />
				<@jmesa.htmlColumn property="legalPerson" title="法人代表" />
				<@jmesa.htmlColumn property="legalContact" title="联系电话" />
				<@jmesa.htmlColumn property="industrial" title="所属行业" >
					<@enum.getSelectEnum companyInfo.industrial/>
				</@jmesa.htmlColumn>

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
        window.open('companyInfo_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

